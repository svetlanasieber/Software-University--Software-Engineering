package bank.entities.client;

public class Adult extends BaseClient {
    private static final int INITIAL_INTEREST_FOR_ADULT = 4;
    private static final int INCREASE_INTEREST_PERCENT_FOR_ADULT = 2;


    //TODO
    //Can only live in CentralBank!

    public Adult(String name, String ID, double income) {
        super(name, ID, INITIAL_INTEREST_FOR_ADULT, income);
    }

    @Override
    public void increase() {
        setIncome(this.getIncome() + INCREASE_INTEREST_PERCENT_FOR_ADULT);
    }
}
