package MidExam_16_02_2025;

import java.util.Arrays;
import java.util.Scanner;

public class TheAngryCat_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] priceRatings = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int entryPoint = Integer.parseInt(scanner.nextLine());
        String typeOfItems = scanner.nextLine();

        int entryValue = priceRatings[entryPoint];
        int leftDamage = 0;
        int rightDamage = 0;


        for (int i = 0; i < entryPoint; i++) {
            if (typeOfItems.equals("cheap") && priceRatings[i] < entryValue) {
                leftDamage += priceRatings[i];
            } else if (typeOfItems.equals("expensive") && priceRatings[i] >= entryValue) {
                leftDamage += priceRatings[i];
            }
        }


        for (int i = entryPoint + 1; i < priceRatings.length; i++) {
            if (typeOfItems.equals("cheap") && priceRatings[i] < entryValue) {
                rightDamage += priceRatings[i];
            } else if (typeOfItems.equals("expensive") && priceRatings[i] >= entryValue) {
                rightDamage += priceRatings[i];
            }
        }


        if (leftDamage >= rightDamage) {
            System.out.println("Left - " + leftDamage);
        } else {
            System.out.println("Right - " + rightDamage);
        }

        scanner.close();
    }
}
