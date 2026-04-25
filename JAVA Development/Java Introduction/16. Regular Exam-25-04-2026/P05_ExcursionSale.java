package P05_ExcursionSale;

import java.util.Scanner;

public class P05_ExcursionSale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seaPackages = Integer.parseInt(scanner.nextLine());
        int mountainPackages = Integer.parseInt(scanner.nextLine());

        int profit = 0;
        boolean allSold = false;

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("Stop")) {
                break;
            }

            if (command.equals("sea") && seaPackages > 0) {
                profit += 680;
                seaPackages--;
            } else if (command.equals("mountain") && mountainPackages > 0) {
                profit += 499;
                mountainPackages--;
            }

            if (seaPackages == 0 && mountainPackages == 0) {
                allSold = true;
                break;
            }
        }

        if (allSold) {
            System.out.println("Good job! Everything is sold.");
        }
        System.out.printf("Profit: %d leva.%n", profit);
    }
}

