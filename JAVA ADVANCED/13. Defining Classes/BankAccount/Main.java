package _06_DefiningClasses._01_Lab._03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bank = new HashMap<>();

        while (!"End".equals(input)) {
            String[] inputArr = input.split("\\s+");
            String command = inputArr[0];

            switch (command) {
                case "Create":
                    create(bank);
                    break;
                case "Deposit":
                    deposit(bank, inputArr);
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(inputArr[1]));
                    break;
                default:
                    printInterest(bank, inputArr);
            }

            input = scanner.nextLine();
        }
    }

    private static void printInterest(Map<Integer, BankAccount> bank, String[] inputArr) {
        int id = Integer.parseInt(inputArr[1]);

        if (!checkAccountExists(bank, id)) {
            return;
        }
        BankAccount account = bank.get(id);
        int years = Integer.parseInt(inputArr[2]);

        System.out.printf("%.2f%n", account.getInterest(years));
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }

    private static void create(Map<Integer, BankAccount> bank) {
        BankAccount account = new BankAccount();
        bank.put(account.getId(), account);
        System.out.println("Account ID" + account.getId() + " created");
    }

    private static void deposit(Map<Integer, BankAccount> bank, String[] inputArr) {
        int id = Integer.parseInt(inputArr[1]);

        if (!checkAccountExists(bank, id)) {
            return;
        }

        int amount = Integer.parseInt(inputArr[2]);
        BankAccount account = bank.get(id);

        account.deposit(amount);
        System.out.println("Deposited " + amount + " to ID" + id);

    }

    public static boolean checkAccountExists(Map<Integer, BankAccount> bank, int id) {
        if (!bank.containsKey(id)) {
            System.out.println("Account does not exist");
            return false;
        }
        return true;
    }
}
