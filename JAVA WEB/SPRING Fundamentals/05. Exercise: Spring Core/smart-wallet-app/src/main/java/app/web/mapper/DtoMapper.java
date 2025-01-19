package app.web.mapper;

import app.subscription.model.Subscription;
import app.subscription.model.SubscriptionPeriod;
import app.subscription.model.SubscriptionStatus;
import app.subscription.model.SubscriptionType;
import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.transaction.model.TransactionType;
import app.user.model.User;
import app.user.model.UserRole;
import app.wallet.model.Wallet;
import app.web.dto.SubscriptionHistory;
import app.web.dto.SystemReport;
import app.web.dto.SystemReport.SystemReportBuilder;
import app.web.dto.TransactionResult;
import app.web.dto.UserInformation;
import java.math.BigDecimal;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoMapper {

    public static TransactionResult toTransactionResult(Transaction transaction) {

        return TransactionResult.builder()
                .id(transaction.getId())
                .status(transaction.getStatus())
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .balanceLeft(transaction.getBalanceLeft())
                .currency(transaction.getCurrency())
                .type(transaction.getType())
                .failureReason(transaction.getFailureReason())
                .createdOn(transaction.getCreatedOn())
                .build();
    }

    public static SubscriptionHistory toSubscriptionHistory(Subscription subscription) {

        return SubscriptionHistory.builder()
                .id(subscription.getId())
                .type(subscription.getType())
                .status(subscription.getStatus())
                .period(subscription.getPeriod())
                .price(subscription.getPrice())
                .start(subscription.getCreatedOn())
                .end(subscription.getCompletedOn())
                .build();
    }

    public static UserInformation toUserInformation(User user) {

        return UserInformation.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .country(user.getCountry())
                .isActive(user.isActive())
                .createdOn(user.getCreatedOn())
                .build();
    }

    public static SystemReport mapToSystemReport(List<User> users,
            List<Wallet> wallets,
            List<Transaction> transactions,
            List<Subscription> subscriptions) {

        SystemReport.SystemReportBuilder reportBuilder = SystemReport.builder();

        buildUserReport(reportBuilder, users);
        buildWalletReport(reportBuilder, wallets, users);
        buildTransactionReport(reportBuilder, transactions);
        buildSubscriptionReport(reportBuilder, subscriptions);

        return reportBuilder.build();
    }

    private static void buildSubscriptionReport(SystemReportBuilder reportBuilder, List<Subscription> subscriptions) {

        reportBuilder.totalCountDefaultSubscriptions(subscriptions.stream()
                .filter(subscription -> subscription.getStatus() == SubscriptionStatus.ACTIVE)
                .filter(subscription -> subscription.getType() == SubscriptionType.DEFAULT)
                .count()
        );
        reportBuilder.totalCountPremiumSubscriptions(subscriptions.stream()
                .filter(subscription -> subscription.getStatus() == SubscriptionStatus.ACTIVE)
                .filter(subscription -> subscription.getType() == SubscriptionType.PREMIUM)
                .count()
        );
        reportBuilder.totalCountUltimateSubscriptions(subscriptions.stream()
                .filter(subscription -> subscription.getStatus() == SubscriptionStatus.ACTIVE)
                .filter(subscription -> subscription.getType() == SubscriptionType.ULTIMATE)
                .count()
        );
        reportBuilder.totalCountMonthlySubscriptions(subscriptions.stream()
                .filter(subscription -> subscription.getStatus() == SubscriptionStatus.ACTIVE)
                .filter(subscription -> subscription.getPeriod() == SubscriptionPeriod.MONTHLY)
                .count()
        );
        reportBuilder.totalCountYearlySubscriptions(subscriptions.stream()
                .filter(subscription -> subscription.getStatus() == SubscriptionStatus.ACTIVE)
                .filter(subscription -> subscription.getPeriod() == SubscriptionPeriod.YEARLY)
                .count()
        );
    }

    private static void buildTransactionReport(SystemReportBuilder reportBuilder, List<Transaction> transactions) {

        long totalTransactions = transactions.size();

        reportBuilder.totalCountTransactions(totalTransactions);
        reportBuilder.totalAmountTransactions(BigDecimal.valueOf(transactions.stream()
                .mapToDouble(transaction -> transaction.getAmount().doubleValue())
                .sum())
        );
        reportBuilder.totalCountWithdrawals(transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.WITHDRAWAL)
                .count()
        );
        reportBuilder.totalCountDeposits(transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.DEPOSIT)
                .count()
        );
        reportBuilder.totalCountSucceededTransactions(transactions.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.SUCCEEDED)
                .count()
        );
        reportBuilder.totalCountFailedTransactions(transactions.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.FAILED)
                .count()
        );
    }

    private static void buildWalletReport(SystemReportBuilder reportBuilder, List<Wallet> wallets, List<User> users) {

        long totalUsers = users.size();
        long usersHavingOneWallet = users.stream().filter(user -> user.getWallets().size() == 1).count();
        long usersHavingTwoWallets = users.stream().filter(user -> user.getWallets().size() == 2).count();
        long usersHavingThreeWallets = users.stream().filter(user -> user.getWallets().size() == 3).count();

        reportBuilder.totalCountWallets((long) wallets.size());
        reportBuilder.totalWalletsAmount(BigDecimal.valueOf(wallets.stream().mapToDouble(wallet -> wallet.getBalance().doubleValue()).sum()));
        reportBuilder.userPercentageOwningOneWallet(BigDecimal.valueOf(usersHavingOneWallet / (totalUsers * 1.00) * 100.00));
        reportBuilder.userPercentageOwningTwoWallets(BigDecimal.valueOf(usersHavingTwoWallets / (totalUsers * 1.00) * 100.00));
        reportBuilder.userPercentageOwningThreeWallets(BigDecimal.valueOf(usersHavingThreeWallets / (totalUsers * 1.00) * 100.00));
    }

    private static void buildUserReport(SystemReportBuilder reportBuilder, List<User> users) {

        reportBuilder.totalCountUsers((long) users.size());
        reportBuilder.totalCountActiveUsers(users.stream().filter(User::isActive).count());
        reportBuilder.totalCountInactiveUsers(users.stream().filter(user -> !user.isActive()).count());
        reportBuilder.totalCountAdmins(users.stream().filter(user -> user.getRole() == UserRole.ADMIN).count());
        reportBuilder.totalCountNonAdmins(users.stream().filter(user -> user.getRole() == UserRole.USER).count());
    }
}
