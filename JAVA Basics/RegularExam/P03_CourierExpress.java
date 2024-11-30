import java.util.Scanner;

public class P03_CourierExpress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        double weight = Double.parseDouble(scanner.nextLine());
        String service = scanner.nextLine();
        double range = Double.parseDouble(scanner.nextLine());

        double price = 0;


        if (service.equals("standard")) {
            if (weight < 1) {
                price += range * 0.03;
            } else if (weight >= 1 && weight <= 10) {
                price += range * 0.05;
            } else if (weight >= 11 && weight <= 40) {
                price += range * 0.10;
            } else if (weight >= 41 && weight <= 90) {
                price += range * 0.15;
            } else if (weight >= 91 && weight <= 150) {
                price += range * 0.20;
            }
        } else if (service.equals("express")) {
            if (weight < 1) {
                price += range * 0.03 + 0.03 * 0.8 * weight * range;
            } else if (weight >= 1 && weight <= 10) {
                price += range * 0.05 + 0.05 * 0.4 * weight * range;
            } else if (weight >= 11 && weight <= 40) {
                price += range * 0.10 + 0.10 * 0.05 * weight * range;
            } else if (weight >= 41 && weight <= 90) {
                price += range * 0.15 + 0.15 * 0.02 * weight * range;
            } else if (weight >= 91 && weight <= 150) {
                price += range * 0.20 + 0.20 * 0.01 * weight * range;
            }
        }


        System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.%n", weight, price);
    }
}
