import java.util.Scanner;

public class P01_CatDiet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int percentFats = scanner.nextInt();
        int percentProteins = scanner.nextInt();
        int percentCarbohydrates = scanner.nextInt();
        int totalCalories = scanner.nextInt();
        int percentWater = scanner.nextInt();

        // Constants for calories per gram
        int oneGramFats = 9;
        int oneGramProteins = 4;
        int oneGramCarbohydrates = 4;


        double totalFats = ((percentFats * totalCalories) / 100.0) / oneGramFats;
        double totalProteins = ((percentProteins * totalCalories) / 100.0) / oneGramProteins;
        double totalCarbohydrates = ((percentCarbohydrates * totalCalories) / 100.0) / oneGramCarbohydrates;


        double totalFood = totalFats + totalCarbohydrates + totalProteins;
        double caloriesPerGramFood = totalCalories / totalFood;


        double waterInCalories = (percentWater * caloriesPerGramFood) / 100.0;
        double calories = caloriesPerGramFood - waterInCalories;


        System.out.printf("%.4f", calories);
    }
}


