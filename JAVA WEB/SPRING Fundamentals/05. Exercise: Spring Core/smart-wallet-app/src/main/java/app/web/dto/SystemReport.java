package app.web.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SystemReport {

    private Long totalCountUsers;
    private Long totalCountActiveUsers;
    private Long totalCountInactiveUsers;
    private Long totalCountAdmins;
    private Long totalCountNonAdmins;

    private Long totalCountWallets;
    private BigDecimal totalWalletsAmount;
    private BigDecimal userPercentageOwningOneWallet;
    private BigDecimal userPercentageOwningTwoWallets;
    private BigDecimal userPercentageOwningThreeWallets;

    private Long totalCountTransactions;
    private BigDecimal totalAmountTransactions;
    private Long totalCountWithdrawals;
    private Long totalCountDeposits;
    private Long totalCountSucceededTransactions;
    private Long totalCountFailedTransactions;

    private Long totalCountDefaultSubscriptions;
    private Long totalCountPremiumSubscriptions;
    private Long totalCountUltimateSubscriptions;
    private Long totalCountMonthlySubscriptions;
    private Long totalCountYearlySubscriptions;
}
