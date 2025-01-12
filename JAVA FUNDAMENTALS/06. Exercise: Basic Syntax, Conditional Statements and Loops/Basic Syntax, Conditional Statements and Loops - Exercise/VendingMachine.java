package Exercise06_BasicSyntax;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("Start")) {
            double coin = Double.parseDouble(command);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                balance += coin;
            } else {
                System.out.printf("Cannot accept %.1f%n", coin);
            }
            command = scanner.nextLine();
        }

       
        final double NUTS_PRICE = 2.0;
        final double WATER_PRICE = 0.7;
        final double CRISPS_PRICE = 1.5;
        final double SODA_PRICE = 0.8;
        final double COKE_PRICE = 1.0;

       
        command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "Nuts" -> {
                    if (balance >= NUTS_PRICE) {
                        balance -= NUTS_PRICE;
                        System.out.println("Purchased Nuts");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                }
                case "Water" -> {
                    if (balance >= WATER_PRICE) {
                        balance -= WATER_PRICE;
                        System.out.println("Purchased Water");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                }
                case "Crisps" -> {
                    if (balance >= CRISPS_PRICE) {
                        balance -= CRISPS_PRICE;
                        System.out.println("Purchased Crisps");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                }
                case "Soda" -> {
                    if (balance >= SODA_PRICE) {
                        balance -= SODA_PRICE;
                        System.out.println("Purchased Soda");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                }
                case "Coke" -> {
                    if (balance >= COKE_PRICE) {
                        balance -= COKE_PRICE;
                        System.out.println("Purchased Coke");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                }
                default -> System.out.println("Invalid product");
            }
            command = scanner.nextLine();
        }

        System.out.printf("Change: %.2f%n", balance);
        scanner.close();


    }
}
