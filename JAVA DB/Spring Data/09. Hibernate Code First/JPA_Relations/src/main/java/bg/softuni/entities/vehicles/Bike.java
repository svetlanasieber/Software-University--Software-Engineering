package bg.softuni.entities.vehicles;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@Table(name = "bikes")
@DiscriminatorValue("BIKE")
public class Bike extends Vehicle {
    @Column(name = "wheel_size")
    private double wheelSize;

    public Bike() {
        super("BIKE", 1);
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }
}
