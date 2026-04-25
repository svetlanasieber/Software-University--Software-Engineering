package P02_FootballKit;

import java.util.Scanner;

public class P02_FootballKit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tShirtPrice = Double.parseDouble(scanner.nextLine());
        double targetSum = Double.parseDouble(scanner.nextLine());

        double shortsPrice = tShirtPrice * 0.75;
        double socksPrice = shortsPrice * 0.20;
        double bootsPrice = (tShirtPrice + shortsPrice) * 2;

        double totalPrice = tShirtPrice + shortsPrice + socksPrice + bootsPrice;
        double finalPrice = totalPrice - (totalPrice * 0.15);

        if (finalPrice >= targetSum) {
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.%n", finalPrice);
        } else {
            double needed = targetSum - finalPrice;
            System.out.println("No, he will not earn the world-cup replica ball.");
            System.out.printf("He needs %.2f lv. more.%n", needed);
        }
    }
}
