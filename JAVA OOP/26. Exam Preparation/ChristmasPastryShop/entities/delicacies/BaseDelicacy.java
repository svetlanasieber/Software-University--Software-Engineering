package christmasPastryShop.entities.delicacies;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseDelicacy implements Delicacy {

    private String name;
    private double portion;
    private double price;

    protected BaseDelicacy(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {

        return String.format("%s: %.2fg - %.2f", this.name, this.portion, this.price);

    }
}
