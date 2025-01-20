package solid.calculators;

import solid.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator{

    @Override
    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.getCalories();
        }

        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
