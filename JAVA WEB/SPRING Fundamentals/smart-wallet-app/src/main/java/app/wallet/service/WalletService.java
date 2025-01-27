package app.wallet.service;

import app.exception.DomainException;
import app.subscription.model.Subscription;
import app.subscription.model.SubscriptionType;
import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.transaction.model.TransactionType;
import app.transaction.service.TransactionService;
import app.user.model.User;
import app.wallet.model.Wallet;
import app.wallet.model.WalletStatus;
import app.wallet.property.WalletProperties;
import app.wallet.repository.WalletRepository;

import app.web.dto.TransferRequest;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class WalletService {

    public static final String SMART_WALLET_LTD = "Smart Wallet Ltd";

    private final WalletRepository repository;
    private final WalletProperties properties;
    private final TransactionService transactionService;
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository repository,
            WalletProperties properties,
            TransactionService transactionService,
            WalletRepository walletRepository) {

        this.repository = repository;
        this.properties = properties;
        this.transactionService = transactionService;
        this.walletRepository = walletRepository;
    }

    public Wallet createNewWallet(User user) {

        List<Wallet> wallets = repository.findAllByOwnerId(user.getId());
        SubscriptionType subscriptionType = user.getSubscriptions().get(0).getType();

        boolean isDefaultAndAlreadyHaveMaxWallets = subscriptionType == SubscriptionType.DEFAULT && wallets.size() == 1;
        boolean isPremiumAndAlreadyHaveMaxWallets = subscriptionType == SubscriptionType.PREMIUM && wallets.size() == 2;
        boolean isUltimateAndAlreadyHaveMaxWallets =
                subscriptionType == SubscriptionType.ULTIMATE && wallets.size() == 3;

        if (isDefaultAndAlreadyHaveMaxWallets || isPremiumAndAlreadyHaveMaxWallets
                || isUltimateAndAlreadyHaveMaxWallets) {
            return wallets.get(0);
        }

        Wallet newWallet = initializeNewWallet(user);
        log.info("Successfully created new wallet with id [%s] for user with id [%s]".formatted(newWallet.getId(),
                user.getId()));

        return repository.save(newWallet);
    }

    private Wallet initializeNewWallet(User owner) {

        WalletProperties.DefaultWalletProperty defaultWalletProperties = properties.getDefaultWalletProperties();

        return Wallet.builder()
                .id(UUID.randomUUID())
                .owner(owner)
                .currency(Currency.getInstance("EUR"))
                .status(defaultWalletProperties.getDefaultStatus())
                .balance(defaultWalletProperties.getInitialBalance())
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();
    }

    public Transaction charge(User user, UUID walletId, BigDecimal amount, String chargeDescription) {

        Wallet wallet = getWalletById(walletId);

        if (wallet.getStatus() == WalletStatus.INACTIVE) {
            String failureReason = "Inactive wallet";
            return transactionService.createNewTransaction(user, walletId.toString(), SMART_WALLET_LTD, amount,
                    wallet.getBalance(), wallet.getCurrency(), TransactionStatus.FAILED, TransactionType.WITHDRAWAL,
                    chargeDescription, failureReason);
        }

        if (wallet.getBalance().compareTo(amount) < 0) {
            String failureReason = "Insufficient funds, top up your account";
            return transactionService.createNewTransaction(user, walletId.toString(), SMART_WALLET_LTD, amount,
                    wallet.getBalance(), wallet.getCurrency(), TransactionStatus.FAILED, TransactionType.WITHDRAWAL,
                    chargeDescription, failureReason);
        }

        BigDecimal newBalance = wallet.getBalance().subtract(amount);
        wallet.setBalance(newBalance);
        wallet.setUpdatedOn(LocalDateTime.now());

        walletRepository.save(wallet);

        return transactionService.createNewTransaction(user, walletId.toString(), SMART_WALLET_LTD, amount, newBalance,
                wallet.getCurrency(), TransactionStatus.SUCCEEDED, TransactionType.WITHDRAWAL, chargeDescription, null);
    }

    @Transactional
    public Transaction transferFunds(User sender, TransferRequest transferRequest) {

        Wallet senderWallet = getWalletById(transferRequest.getFromWalletId());
        Optional<Wallet> receiverWalletOptional = walletRepository.findAllByOwnerUsername(
                        transferRequest.getToUsername())
                .stream()
                .filter(w -> w.getStatus() == WalletStatus.ACTIVE)
                .findFirst();
        String transferDescription = "%.2f %s from %s".formatted(transferRequest.getAmount(),
                senderWallet.getCurrency(), sender.getUsername());

        if (receiverWalletOptional.isEmpty()) {

            return transactionService.createNewTransaction(sender,
                    senderWallet.getId().toString(),
                    transferRequest.getToUsername(),
                    transferRequest.getAmount(),
                    senderWallet.getBalance(),
                    senderWallet.getCurrency(),
                    TransactionStatus.FAILED,
                    TransactionType.WITHDRAWAL,
                    transferDescription,
                    "Unable to perform transfer due to criteria not met");
        }

        Wallet receiverWallet = receiverWalletOptional.get();

        BigDecimal transferTax = calculateTransferTax(sender, transferRequest.getAmount());
        boolean isEligibleForCountryTax = sender.getCountry() != receiverWallet.getOwner().getCountry()
                && sender.getSubscriptions().get(0).getType() != SubscriptionType.ULTIMATE;
        BigDecimal countryTax = isEligibleForCountryTax
                ? BigDecimal.valueOf(0.20)
                : BigDecimal.ZERO;

        Transaction withdrawal = charge(sender, transferRequest.getFromWalletId(),
                transferRequest.getAmount().add(transferTax).add(countryTax), transferDescription);
        if (withdrawal.getStatus() == TransactionStatus.FAILED) {
            return withdrawal;
        }

        BigDecimal newReceiverBalance = receiverWallet.getBalance().add(transferRequest.getAmount());
        receiverWallet.setBalance(newReceiverBalance);
        receiverWallet.setUpdatedOn(LocalDateTime.now());

        walletRepository.save(receiverWallet);
        transactionService.createNewTransaction(receiverWallet.getOwner(),
                senderWallet.getId().toString(),
                receiverWallet.getId().toString(),
                transferRequest.getAmount(),
                newReceiverBalance,
                receiverWallet.getCurrency(),
                TransactionStatus.SUCCEEDED,
                TransactionType.DEPOSIT,
                transferDescription,
                null);

        return withdrawal;
    }

    private BigDecimal calculateTransferTax(User sender, BigDecimal transferAmount) {

        double percentage = 0;

        Subscription currentActiveSubscription = sender.getSubscriptions().get(0);
        switch (currentActiveSubscription.getType()) {
            case DEFAULT -> percentage = 0.15;
            case PREMIUM -> percentage = 0.08;
            case ULTIMATE -> percentage = 0.02;
        }

        return transferAmount.multiply(BigDecimal.valueOf(percentage));
    }

    private Wallet getWalletById(UUID walletId) {

        Optional<Wallet> walletOptional = walletRepository.findById(walletId);

        if (walletOptional.isEmpty()) {
            String message = "Wallet with id [%s] was not found.".formatted(walletId);
            throw new DomainException(message, HttpStatus.BAD_REQUEST);
        }

        return walletOptional.get();
    }

    public Map<UUID, List<Transaction>> getLastFourTransactionsForWallets(List<Wallet> wallets) {

        Map<UUID, List<Transaction>> walletTransactions = new LinkedHashMap<>();

        for (Wallet wallet : wallets) {

            List<Transaction> lastFiveTransactions = transactionService.getLastFourTransactions(wallet);
            walletTransactions.put(wallet.getId(), lastFiveTransactions);
        }

        return walletTransactions;
    }

    public Transaction topUp(UUID walletId, BigDecimal amount) {

        Wallet wallet = getWalletById(walletId);

        if (wallet.getStatus() == WalletStatus.INACTIVE) {

            return transactionService.createNewTransaction(wallet.getOwner(),
                    SMART_WALLET_LTD,
                    wallet.getId().toString(),
                    amount,
                    wallet.getBalance(),
                    wallet.getCurrency(),
                    TransactionStatus.FAILED,
                    TransactionType.DEPOSIT,
                    "Top up " + amount,
                    "Inactive wallet");
        }

        wallet.setBalance(wallet.getBalance().add(amount));
        wallet.setUpdatedOn(LocalDateTime.now());

        walletRepository.save(wallet);

        return transactionService.createNewTransaction(wallet.getOwner(),
                SMART_WALLET_LTD,
                wallet.getId().toString(),
                amount,
                wallet.getBalance(),
                wallet.getCurrency(),
                TransactionStatus.SUCCEEDED,
                TransactionType.DEPOSIT,
                "Top up " + amount,
                null);
    }

    public void switchStatus(UUID userId, UUID walletId) {

        Wallet wallet = getWalletById(walletId);

        if (!wallet.getOwner().getId().equals(userId)) {
            String message = "User with id [%s] is not associated with wallet with id [%s]".formatted(userId, walletId);
            throw new DomainException(message, HttpStatus.FORBIDDEN);
        }

        wallet.setStatus(wallet.getStatus() == WalletStatus.ACTIVE ? WalletStatus.INACTIVE : WalletStatus.ACTIVE);
        wallet.setUpdatedOn(LocalDateTime.now());

        walletRepository.save(wallet);
    }

    public List<Wallet> getAllWallets() {

        return walletRepository.findAll();
    }
}
