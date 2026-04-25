package P01_ChristmasPreparation;

import java.util.Scanner;

public class P01_ChristmasPreparation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int paperRolls = Integer.parseInt(scanner.nextLine());
        int fabricRolls = Integer.parseInt(scanner.nextLine());
        double glueLiters = Double.parseDouble(scanner.nextLine());
        int discountPercent = Integer.parseInt(scanner.nextLine());

        double paperPrice = paperRolls * 5.80;
        double fabricPrice = fabricRolls * 7.20;
        double gluePrice = glueLiters * 1.20;

        double totalPrice = paperPrice + fabricPrice + gluePrice;
        double finalPrice = totalPrice - (totalPrice * discountPercent / 100.0);

        System.out.printf("%.3f%n", finalPrice);
    }
}
