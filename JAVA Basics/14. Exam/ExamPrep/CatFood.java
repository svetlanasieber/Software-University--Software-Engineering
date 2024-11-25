package FirstStepsInCoding.Lab.Exam;

import java.util.Scanner;

public class CatFood {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cats = Integer.parseInt(scanner.nextLine());

        int counter = 1;
        int group1 = 0;
        int group2 = 0;
        int group3 = 0;

        double totalFood = 0;

        while (counter <= cats){
            double foodInGrams = Double.parseDouble(scanner.nextLine());
            totalFood += foodInGrams;
            if (foodInGrams >= 100 && foodInGrams < 200){
                group1++;
            } else if (foodInGrams >= 200 && foodInGrams < 300) {
                group2++;
                
            } else if (foodInGrams >= 300 && foodInGrams <= 400) {
                group3++;
                
            }
            counter++;

        }
        double price = (totalFood / 1000) * 12.45;
        System.out.printf("Group 1: %d cats.%n", group1);
        System.out.printf("Group 2: %d cats.%n", group2);
        System.out.printf("Group 3: %d cats.%n", group3);
        System.out.printf("Price for food per day: %.2f lv.", price);
    }
}
