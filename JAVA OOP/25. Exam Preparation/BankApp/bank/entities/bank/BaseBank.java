package bank.entities.bank;

import bank.common.ExceptionMessages;
import bank.entities.client.Client;
import bank.entities.loan.Loan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseBank implements Bank {
    private static final String CENTRAL_BANK = "CentralBank";
    private static final String BRANCH_BANK = "BranchBank";

    private String name;
    private int capacity;
    private Collection<Loan> loans;
    private Collection<Client> clients;

    public BaseBank(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.loans = new ArrayList<>();
        this.clients = new ArrayList<>();

    }

    @Override
    public int sumOfInterestRates() {
        return this.getLoans().stream().mapToInt(Loan::getInterestRate).sum();

    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;

    }

    public void addClient(Client client) {
        if (this.capacity > this.clients.size()) {
            this.clients.add(client);
            return;
        }
        throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT);
    }

    public void removeClient(Client client) {

        this.getClients().remove(client);

    }

    public void addLoan(Loan loan) {
        this.getLoans().add(loan);
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s, Type: %s", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());
        if (getClients().isEmpty()) {
            builder.append("Clients: none");
        } else {
            String s = "Clients: " +this.getClients().stream().map(Client::getName).collect(Collectors.joining(", ")).trim() + System.lineSeparator()
                    + String.format("Loans: %s, Sum of interest rates: %s", this.getLoans().size(), this.sumOfInterestRates());
            builder.append(s);

        }
        return builder.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Collection<Loan> getLoans() {
        return loans;
    }

    @Override
    public Collection<Client> getClients() {
        return clients;
    }
}
