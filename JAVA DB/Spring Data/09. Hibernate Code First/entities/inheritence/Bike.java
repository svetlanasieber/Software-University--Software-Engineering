package entities.inheritence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle {
    private final static String TYPE = "BIKE";

    @Column(name = "wheel_size")
    private int wheelSize;

    public Bike() {
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }
}
