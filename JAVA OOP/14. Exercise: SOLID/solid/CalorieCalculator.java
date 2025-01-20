package solid;

import solid.products.Chocolate;
import solid.products.Coke;
import solid.products.Lemonade;

import java.util.List;

public class CalorieCalculator {

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    public CalorieCalculator() {
    }

    public double sum(List<Object> products) {
        double sum = 0;

        for (Object product : products) {
            if (product instanceof Coke) {
                double grams = ((Coke) product).getMilliliters() * Coke.DENSITY;
                sum += (Coke.CALORIES_PER_100_GRAMS / 100) * grams;
            }

            if (product instanceof Lemonade) {
                double grams = ((Lemonade) product).getMilliliters() * Lemonade.DENSITY;
                sum += (Lemonade.CALORIES_PER_100_GRAMS / 100) * grams;
            }

            if (product instanceof Chocolate) {
                sum += (Chocolate.CALORIES_PER_100_GRAMS / 100) * ((Chocolate) product).getGrams();
            }
        }

        return sum;
    }

    public double average(List<Object> products) {
        return sum(products) / products.size();
    }

    public void printSum(List<Object> products) {
        System.out.printf((SUM) + "%n", sum(products));
    }

    public void printAverage(List<Object> products) {
        System.out.printf((AVERAGE) + "%n", average(products));
    }
}
