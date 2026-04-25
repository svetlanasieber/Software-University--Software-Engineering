package P03_ExcursionCalculator;

import java.util.Scanner;

public class P03_ExcursionCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();

        double pricePerPerson = 0;

        if (people <= 5) {
            switch (season) {
                case "spring":
                    pricePerPerson = 50.00;
                    break;
                case "summer":
                    pricePerPerson = 48.50;
                    break;
                case "autumn":
                    pricePerPerson = 60.00;
                    break;
                case "winter":
                    pricePerPerson = 86.00;
                    break;
            }
        } else {
            switch (season) {
                case "spring":
                    pricePerPerson = 48.00;
                    break;
                case "summer":
                    pricePerPerson = 45.00;
                    break;
                case "autumn":
                    pricePerPerson = 49.50;
                    break;
                case "winter":
                    pricePerPerson = 85.00;
                    break;
            }
        }

        double totalPrice = people * pricePerPerson;

        if (season.equals("summer")) {
            totalPrice -= totalPrice * 0.15;
        } else if (season.equals("winter")) {
            totalPrice += totalPrice * 0.08;
        }

        System.out.printf("%.2f leva.%n", totalPrice);
    }
}
