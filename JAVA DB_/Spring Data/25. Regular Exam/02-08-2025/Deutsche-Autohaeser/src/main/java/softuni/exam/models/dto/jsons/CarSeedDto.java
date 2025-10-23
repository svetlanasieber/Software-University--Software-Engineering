package softuni.exam.models.dto.jsons;

import com.google.gson.annotations.Expose;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

public class CarSeedDto implements Serializable {

    @Expose
    @NotBlank
    @Size(min = 2, max = 30)
    private String brand;

    @Expose
    @NotBlank
    @Size(min = 2, max = 30)
    private String model;

    @Expose
    @NotBlank
    @Size(min = 17, max = 17)
    private String VIN;

    @Expose
    @NotNull
    @Positive
    private Integer mileage;

    @Expose
    @NotBlank
    private String carType;

    @Expose
    @NotNull
    private Long dealership;

    public CarSeedDto() {}

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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Long getDealership() {
        return dealership;
    }

    public void setDealership(Long dealership) {
        this.dealership = dealership;
    }
}