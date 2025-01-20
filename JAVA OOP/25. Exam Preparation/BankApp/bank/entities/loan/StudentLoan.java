package bank.entities.loan;

public class StudentLoan extends BaseLoan{
    private static final int INTEREST_RATE_FOR_STUDENT = 1;
    private static final double AMOUNT_FOR_STUDENT = 10000;
    public StudentLoan() {
        super(INTEREST_RATE_FOR_STUDENT, AMOUNT_FOR_STUDENT);
    }

}
