package softuni.exam.models.entity;

import jakarta.persistence.*;
import softuni.exam.models.enums.CarType;

import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(unique = true, nullable = false)
    private String VIN;

    @Column(nullable = false)
    private Integer mileage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarType carType;

    @ManyToOne
    @JoinColumn(name = "dealership_id")
    private Dealership dealership;

    @OneToMany(mappedBy = "offeringCar", fetch = FetchType.LAZY)
    private Set<Dealer> dealers;

    public Car() {}

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

    public Set<Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(Set<Dealer> dealers) {
        this.dealers = dealers;
    }
}