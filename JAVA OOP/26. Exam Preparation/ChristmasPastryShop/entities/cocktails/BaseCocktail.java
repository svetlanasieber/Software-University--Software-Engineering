package christmasPastryShop.entities.cocktails;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.Objects;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseCocktail implements Cocktail {

    private String name;
    private int size;
    private double price;
    private String brand;

    protected BaseCocktail(String name, int size, double price, String brand) {
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
    }


    private void setName(String name) {
        if (isInValidNaming(name)) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
        this.size = size;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    private void setBrand(String brand) {
        if (isInValidNaming(brand)) {
            throw new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }


    private boolean isInValidNaming(String input) {
        return input == null || input.trim().isEmpty();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public String toString() {

        return String.format("%s %s - %dml - %.2flv",this. name, this.brand, this.size, this.price);

    }

}
