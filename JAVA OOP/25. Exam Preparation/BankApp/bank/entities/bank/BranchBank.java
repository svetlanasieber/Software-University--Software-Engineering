package bank.entities.bank;

import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.Collection;

public class BranchBank extends BaseBank {
    private static final int CAPACITY_FROM_BRANCH_BANK = 25;

    public BranchBank(String name) {
        super(name, CAPACITY_FROM_BRANCH_BANK);
    }


}