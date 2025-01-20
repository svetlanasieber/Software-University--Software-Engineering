package solid.products.food;

public abstract class BaseFood implements Food {
    private double grams;
    private double caloriesPer100grams;

    public BaseFood(double grams, double caloriesPer100grams) {
        this.grams = grams;
        this.caloriesPer100grams = caloriesPer100grams;
    }

    @Override
    public double getCalories() {
        return (caloriesPer100grams / 100) * grams;
    }

    @Override
    public double getKilograms() {
        return this.grams / 1000;
    }
}
