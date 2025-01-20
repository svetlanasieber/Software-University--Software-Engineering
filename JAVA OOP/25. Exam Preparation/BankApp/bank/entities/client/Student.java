package bank.entities.client;

public class Student extends BaseClient {
    private static final int INITIAL_INTEREST_FOR_STUDENT = 2;
    private static final int INCREASE_INTEREST_FOR_STUDENT = 1;


    //TODO
    //Can only live in BranchBank! ???
    public Student(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST_FOR_STUDENT, income);
    }

    @Override
    public void increase() {
        this.setIncome(this.getIncome() + INCREASE_INTEREST_FOR_STUDENT);

    }
}
