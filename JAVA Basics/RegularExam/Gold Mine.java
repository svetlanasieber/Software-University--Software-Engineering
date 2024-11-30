import java.util.Scanner;

public class GoldMine_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int locations = scanner.nextInt();

        for (int i = 0; i < locations; i++) {

            double goldPerDayExpected = scanner.nextDouble();

            int workdays = scanner.nextInt();
            double totalGold = 0;

            for (int j = 0; j < workdays; j++) {

                double goldPerDay = scanner.nextDouble();
                totalGold += goldPerDay;
            }

            double average = totalGold / workdays;

            if (average >= goldPerDayExpected) {
                System.out.printf("Good job! Average gold per day: %.2f.%n", average);
            } else {
                System.out.printf("You need %.2f gold.%n", (goldPerDayExpected - average));
            }
        }

        scanner.close();




    }
}
