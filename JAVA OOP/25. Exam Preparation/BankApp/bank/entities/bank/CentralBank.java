package bank.entities.bank;

public class CentralBank extends BaseBank{
    private static final int CAPACITY_OF_CENTRAL_BANK = 50;

    public CentralBank(String name) {
        super(name, CAPACITY_OF_CENTRAL_BANK);
    }
}
