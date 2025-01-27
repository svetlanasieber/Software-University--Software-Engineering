package app.subscription.service;

import app.exception.DomainException;
import app.subscription.model.Subscription;
import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionStatus;
import app.subscription.model.SubscriptionType;
import app.subscription.property.SubscriptionProperties;
import app.subscription.repository.SubscriptionRepository;
import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.user.model.User;
import app.wallet.service.WalletService;
import app.web.dto.UpgradeOption;
import app.web.dto.UpgradeRequest;
import app.web.dto.UpgradeResult;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;

import static app.subscription.model.SubscriptionType.*;

@Service
@Slf4j
public class SubscriptionService {

    private final SubscriptionRepository repository;
    private final SubscriptionProperties properties;
    private final WalletService walletService;

    public SubscriptionService(SubscriptionRepository repository,
                               SubscriptionProperties properties,
                               WalletService walletService) {

        this.repository = repository;
        this.properties = properties;
        this.walletService = walletService;
    }

    public Subscription createDefaultSubscription(User user) {

        Subscription subscription = buildNewUserSubscription(user, DEFAULT, properties.getDefaultPeriod(), BigDecimal.ZERO);
        log.info("Successfully created new [%s] subscription with id [%s].".formatted(subscription.getType(), subscription.getId()));

        return repository.save(subscription);
    }

    private Subscription buildNewUserSubscription(User owner, SubscriptionType type, SubscriptionPeriod period, BigDecimal price) {

        LocalDateTime createdOn = LocalDateTime.now();
        LocalDateTime completedOn = LocalDateTime.now();
        if (period == SubscriptionPeriod.YEARLY) {
            completedOn = completedOn.plusMonths(12);
        } else {
            completedOn = completedOn.plusMonths(1);
        }

        return Subscription.builder()
                .id(UUID.randomUUID())
                .owner(owner)
                .status(SubscriptionStatus.ACTIVE)
                .period(period)
                .type(type)
                .price(price)
                .renewalAllowed(period == SubscriptionPeriod.MONTHLY)
                .createdOn(createdOn)
                .completedOn(completedOn)
                .build();
    }

    public Map<String, UpgradeOption> getUpgradeOptions(UUID userId) {

        Subscription currentUserSubscription = getCurrentActiveSubscription(userId);

        UpgradeOption defaultSubscriptionOption = getOptionByType(DEFAULT);
        UpgradeOption premiumSubscriptionOption = getOptionByType(PREMIUM);
        UpgradeOption ultimateSubscriptionOption = getOptionByType(ULTIMATE);

        switch (currentUserSubscription.getType()) {
            case DEFAULT -> defaultSubscriptionOption.setChoosable(false);
            case PREMIUM -> premiumSubscriptionOption.setChoosable(false);
            case ULTIMATE -> ultimateSubscriptionOption.setChoosable(false);
        }

        return Map.of(
                DEFAULT.name(), defaultSubscriptionOption,
                PREMIUM.name(), premiumSubscriptionOption,
                ULTIMATE.name(), ultimateSubscriptionOption
        );

    }

    @Transactional
    public UpgradeResult upgrade(User user, UpgradeRequest request) {

        Subscription currentUserSubscription = getCurrentActiveSubscription(user.getId());

        SubscriptionType desiredSubscriptionType = SubscriptionType.valueOf(request.getSubscriptionType().toUpperCase());
        SubscriptionPeriod desiredSubscriptionPeriod = SubscriptionPeriod.valueOf(request.getSubscriptionPeriod().toUpperCase());

        BigDecimal price;
        if (desiredSubscriptionPeriod == SubscriptionPeriod.MONTHLY) {
            price = properties.getUpgradeOptions().get(desiredSubscriptionType).getMonthlyPrice();
        } else {
            price = properties.getUpgradeOptions().get(desiredSubscriptionType).getYearlyPrice();
        }

        String chargeDescription = "Purchased %s subscription".formatted(desiredSubscriptionType);
        Transaction chargeResult = walletService.charge(user, UUID.fromString(request.getWalletId()), price, chargeDescription);

        if (chargeResult.getStatus() == TransactionStatus.FAILED) {

            log.warn("Upgrade attempt failed because of [%s].".formatted(chargeResult.getFailureReason()));
            return UpgradeResult.builder()
                    .transaction(chargeResult)
                    .oldSubscription(currentUserSubscription)
                    .newSubscription(currentUserSubscription)
                    .build();
        }

        Subscription newUserSubscription = buildNewUserSubscription(user, desiredSubscriptionType, desiredSubscriptionPeriod, price);
        currentUserSubscription.setCompletedOn(LocalDateTime.now());
        currentUserSubscription.setStatus(SubscriptionStatus.COMPLETED);

        repository.save(currentUserSubscription);
        repository.save(newUserSubscription);

        return UpgradeResult.builder()
                .transaction(chargeResult)
                .oldSubscription(currentUserSubscription)
                .newSubscription(newUserSubscription)
                .build();
    }

    private Subscription getCurrentActiveSubscription(UUID userId) {

        return repository.findByStatusAndOwnerId(SubscriptionStatus.ACTIVE, userId)
                .orElseThrow(() -> new DomainException("User with id [%s] doesn't have any active subscription.".formatted(userId), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    private UpgradeOption getOptionByType(SubscriptionType type) {

        return UpgradeOption.builder()
                .type(type)
                .benefits(properties.getUpgradeOptions().get(type).getBenefits())
                .monthlyPrice(properties.getUpgradeOptions().get(type).getMonthlyPrice())
                .yearlyPrice(properties.getUpgradeOptions().get(type).getYearlyPrice())
                .isChoosable(true)
                .build();
    }

    public List<Subscription> getHistory(UUID userId) {

        return repository.findByOwnerIdOrderByCreatedOnDesc(userId);
    }

    public List<Subscription> getAllSubscriptions() {

        return repository.findAll();
    }

    public List<Subscription> getAllSubscriptionsForRenewal() {

        return repository.findAllByStatusAndCompletedOnBefore(SubscriptionStatus.ACTIVE, LocalDateTime.now());
    }

    public void completeSubscription(Subscription subscription) {

        subscription.setStatus(SubscriptionStatus.COMPLETED);
        subscription.setCompletedOn(LocalDateTime.now());

        repository.save(subscription);
        log.info("Successfully completed subscription with id [%s].".formatted(subscription.getId()));

        createDefaultSubscription(subscription.getOwner());
    }

    public void terminateSubscription(Subscription subscription) {

        subscription.setStatus(SubscriptionStatus.TERMINATED);
        subscription.setCompletedOn(LocalDateTime.now());

        repository.save(subscription);
        log.info("Successfully terminated subscription with id [%s].".formatted(subscription.getId()));

        createDefaultSubscription(subscription.getOwner());
    }
}
