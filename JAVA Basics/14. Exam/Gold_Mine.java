package FirstStepsInCoding.Lab.Exam;

import java.util.Scanner;

public class Gold_Mine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int location = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < location; i++) {
            double averageGoldPerDay = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            double yield = 0;

            for (int j = 0; j < days; j++) {
                int currentYield = Integer.parseInt(scanner.nextLine());
                yield += currentYield;
            }
            double averagePerLocation = (yield / days);
            double diff = Math.abs(averagePerLocation - averageGoldPerDay);

            if (averagePerLocation < averageGoldPerDay){
                System.out.printf("You need %.2f gold.%n", diff);

            }else{
                System.out.printf("Good job! Average gold per day: %.2f.%n", averagePerLocation);

            }

        }
    }
}
