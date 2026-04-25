package P04_Workout;

import java.util.Scanner;

public class P04_Workout {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double currentKm = Double.parseDouble(scanner.nextLine());

        double totalKm = currentKm;

        for (int i = 0; i < days; i++) {
            int percent = Integer.parseInt(scanner.nextLine());
            currentKm += currentKm * percent / 100.0;
            totalKm += currentKm;
        }

        if (totalKm >= 1000) {
            long extra = (long) Math.ceil(totalKm - 1000);
            System.out.printf("You've done a great job running %d more kilometers!%n", extra);
        } else {
            long needed = (long) Math.ceil(1000 - totalKm);
            System.out.printf("Sorry Mrs. Ivanova, you need to run %d more kilometers%n", needed);
        }
    }
}

