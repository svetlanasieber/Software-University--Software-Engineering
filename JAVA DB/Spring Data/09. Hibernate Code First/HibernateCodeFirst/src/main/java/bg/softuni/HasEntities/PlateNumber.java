package bg.softuni.HasEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "has_plate_number")
public class PlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @OneToOne(targetEntity = Truck.class, mappedBy = "plateNumber")
    private Truck truck;

    public PlateNumber (){}

    public PlateNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
