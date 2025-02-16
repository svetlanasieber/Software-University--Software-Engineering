package MidExam_16_02_2025;

import java.util.Scanner;

public class BiscuitFactory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int biscuitsPerWorker = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int competitorProduction = Integer.parseInt(scanner.nextLine());


        int totalBiscuits = 0;
        for (int day = 1; day <= 30; day++) {
            int dailyProduction = biscuitsPerWorker * workers;


            if (day % 3 == 0) {
                dailyProduction = (int) Math.floor(dailyProduction * 0.75);
            }

            totalBiscuits += dailyProduction;
        }


        System.out.println("You have produced " + totalBiscuits + " biscuits for the past month.");


        int difference = totalBiscuits - competitorProduction;
        double percentageDifference = Math.abs(difference) / (double) competitorProduction * 100;


        if (totalBiscuits > competitorProduction) {
            System.out.printf("You produce %.2f percent more biscuits.%n", percentageDifference);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.%n", percentageDifference);
        }

        scanner.close();
    }
}

