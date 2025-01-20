package robotService.entities.robot;

import robotService.common.ExceptionMessages;

public abstract class BaseRobot implements Robot {

    private String name;
    private String kind;
    private int kilograms;
    private double price;

    protected BaseRobot(String name, String kind, int kilograms, double price) {
        setName(name);
        setKind(kind);
        setKilograms(kilograms);
        setPrice(price);
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setKind(String kind) {
        if (kind == null || kind.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);

        }
        this.kind = kind;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }


    @Override
    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public int getKilograms() {
        return kilograms;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    abstract public void eating();


}
