package bank.entities.loan;

public class MortgageLoan extends BaseLoan{
    private static final int INTEREST_RATE_FOR_MORTGAGE = 3;
    private static final double AMOUNT_FOR_MORTGAGE = 50000;
    public MortgageLoan() {
        super(INTEREST_RATE_FOR_MORTGAGE, AMOUNT_FOR_MORTGAGE);
    }
}
