package vehicles;

import java.text.DecimalFormat;

public abstract class AbstractVehicle implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public AbstractVehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double distance) {
        double neededFuel = this.fuelConsumption * distance;
        if (this.fuelQuantity >= neededFuel) {
            this.fuelQuantity -= neededFuel;
            return String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    DECIMAL_FORMAT.format(distance));
        }
        return String.format("%s needs refueling",
                this.getClass().getSimpleName());
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
