package Exercise06_BasicSyntax;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        int ordersCount = Integer.parseInt(scanner.nextLine());
        double total = 0;

        for (int i = 1; i <= ordersCount; i++) {

            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());

            //((daysInMonth * capsulesCount) * pricePerCapsule)
            double price = (days * capsuleCount) * pricePerCapsule;
            total += price;
            System.out.printf("The price for the coffee is: $%.2f%n", price);
        }

        System.out.printf("Total: $%.2f%n", total);


    }
}

