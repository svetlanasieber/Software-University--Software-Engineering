package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import softuni.exam.models.entity.enums.CarType;

public class CarImportDto {

    @Expose
    @Size(min = 2, max = 30)
    private String brand;

    @Expose
    @Size(min = 2, max = 30)
    private String model;

    @Expose
    @Size(min = 17, max = 17)
    private String VIN;

    @Expose
    @Min(0)
    private Integer mileage;

    @Expose
    private CarType carType;

    @Expose
    private Long dealership;

    public CarImportDto() {
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

    public Long getDealership() {
        return dealership;
    }

    public void setDealership(Long dealership) {
        this.dealership = dealership;
    }
}