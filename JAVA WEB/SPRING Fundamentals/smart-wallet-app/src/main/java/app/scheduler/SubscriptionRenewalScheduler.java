package app.scheduler;

import app.subscription.model.Subscription;
import app.subscription.service.SubscriptionService;
import app.transaction.model.TransactionStatus;
import app.user.model.User;
import app.web.dto.UpgradeRequest;
import app.web.dto.UpgradeResult;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class SubscriptionRenewalScheduler {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionRenewalScheduler(SubscriptionService subscriptionService) {

        this.subscriptionService = subscriptionService;
    }

    @Transactional
    @Scheduled(cron = "0 * * * * *")
    public void renewalSubscriptions() {

        List<Subscription> activeSubscriptions = subscriptionService.getAllSubscriptionsForRenewal();

        if (activeSubscriptions.isEmpty()) {
            log.info("No subscriptions to renew");
            return;
        }

        for (Subscription subscription : activeSubscriptions) {

            if (subscription.isRenewalAllowed()) {
                User user = subscription.getOwner();
                UpgradeRequest upgradeToSameSubscription = UpgradeRequest.builder()
                        .subscriptionType(subscription.getType().name())
                        .subscriptionPeriod(subscription.getPeriod().name())
                        .walletId(user.getWallets().get(0).getId().toString())
                        .build();

                UpgradeResult result = subscriptionService.upgrade(user, upgradeToSameSubscription);
                if (result.getTransaction().getStatus() == TransactionStatus.FAILED) {
                    subscriptionService.terminateSubscription(subscription);
                }
            } else {
                subscriptionService.completeSubscription(subscription);
            }
        }
        log.info("Processed successfully [%d] subscriptions.".formatted(activeSubscriptions.size()));
    }
}
