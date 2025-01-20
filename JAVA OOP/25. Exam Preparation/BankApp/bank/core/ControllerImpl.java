package bank.core;

import bank.common.ConstantMessages;
import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;
import bank.repositories.LoanRepository;
import bank.repositories.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static bank.common.ConstantMessages.FUNDS_BANK;
import static bank.common.ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK;

public class ControllerImpl implements Controller {
    private LoanRepository loans;
    private Map<String, Bank> banks;

    public ControllerImpl() {
        this.loans = new LoanRepository();
        this.banks = new LinkedHashMap();
    }

    @Override
    public String addBank(String type, String name) {
        Bank bank;
        switch (type) {
            case "CentralBank":
                bank = new CentralBank(name);
                break;
            case "BranchBank":
                bank = new BranchBank(name);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_BANK_TYPE);


        }
        banks.put(name, bank);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String addLoan(String type) {
        Loan loan;
        switch (type) {
            case "StudentLoan":
                loan = new StudentLoan();
                break;
            case "MortgageLoan":
                loan = new MortgageLoan();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
        }
this.loans.addLoan(loan);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
    }

    @Override
    public String returnedLoan(String bankName, String loanType) {
        Loan loanForService = this.loans.findFirst(loanType);

        if (loanForService == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_LOAN_FOUND, loanType));
        }

        Bank bank = this.banks.get(bankName);
        bank.addLoan(loanForService);
        this.loans.removeLoan(loanForService);

        return String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
    }
    @Override
    public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
        Client client;
        switch (clientType) {
            case "Student":
                client = new Student(clientName, clientID, income);
                break;
            case "Adult":
                client = new Adult(clientName, clientID, income);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CLIENT_TYPE);

        }
        Bank bank = this.banks.get(bankName);
        String printOutput;
        if (!isValidBank(clientType,bank)){
            printOutput =  ConstantMessages.UNSUITABLE_BANK;
        }else {
            bank.addClient(client);
            printOutput = String.format(SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName);
        }

        return printOutput;

    }
    private boolean isValidBank(String clientType, Bank bank){
        String bankType = bank.getClass().getSimpleName();
        if (clientType.equals("Student") && bankType.equals("BranchBank")){
            return true;
        }else return clientType.equals("Adult") && bankType.equals("CentralBank");
    }



    @Override
    public String finalCalculation(String bankName) {
        Bank bank = this.banks.get(bankName);

        double clientPrice = bank.getClients().stream()
                .mapToDouble(Client::getIncome).sum();
        double loanPrice = bank.getLoans().stream()
                .mapToDouble(Loan::getAmount).sum();

        return String.format(FUNDS_BANK, bankName, clientPrice + loanPrice);
    }

    @Override
    public String getStatistics() {


        //"Name: {bankName}, Type: {bankType}

        //Clients: {clientName1}, {clientName2} ... / Clients: none
        //Loans: {loansCount}, Sum of interest rates: {sumOfInterestRates}
        //
        //Name: {bankName}, Type: {bankType}
        //Clients: {clientName1}, {clientName2} ... / Clients: none
        //Loans: {loansCount}, Sum of interest rates: {sumOfInterestRates}





        return banks.values()
                .stream()
                .map(Bank::getStatistics)
                .collect(Collectors.joining(System.lineSeparator())).trim();
    }
}
