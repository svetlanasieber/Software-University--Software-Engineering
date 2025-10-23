package softuni.exam.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import softuni.exam.models.entity.enums.CarType;

import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "brand", nullable = false)
    @Size(min = 2, max = 30)
    private String brand;

    @Column(name = "model", nullable = false)
    @Size(min = 2, max = 30)
    private String model;

    @Column(name = "vin", nullable = false, unique = true, length = 17)
    @Size(min = 17, max = 17)
    private String VIN;

    @Column(name = "mileage", nullable = false)
    @Min(0)
    private Integer mileage;

    @Enumerated(EnumType.STRING)
    @Column(name = "car_type", nullable = false)
    private CarType carType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dealership_id", referencedColumnName = "id")
    private Dealership dealership;

    @OneToMany(mappedBy = "offeringCar")
    private List<Dealer> dealers;

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public List<Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(List<Dealer> dealers) {
        this.dealers = dealers;
    }
}