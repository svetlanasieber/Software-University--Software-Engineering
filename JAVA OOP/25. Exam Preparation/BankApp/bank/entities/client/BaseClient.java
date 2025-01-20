package bank.entities.client;

import bank.common.ExceptionMessages;

public abstract class BaseClient implements Client {


    private String name;
    private String ID;


    private int interest;
    private double income;

    public BaseClient(String name, String ID, int interest, double income) {
        setName(name);
        setID(ID);
        this.interest = interest;
        setIncome(income);
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.CLIENT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setID(String ID) {
        if (ID == null || ID.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.CLIENT_ID_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.ID = ID;

    }

    protected void setIncome(double income) {
        if (income <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.CLIENT_INCOME_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.income = income;
    }

    @Override
    public abstract void increase();

    @Override
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    @Override
    public int getInterest() {
        return interest;
    }

    @Override
    public double getIncome() {
        return income;
    }
}
