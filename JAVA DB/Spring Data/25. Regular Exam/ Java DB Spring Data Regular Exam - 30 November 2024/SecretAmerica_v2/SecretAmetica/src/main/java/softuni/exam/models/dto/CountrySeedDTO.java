package softuni.exam.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CountrySeedDTO {

    private double area;
    private String name;


    @NotNull
    @Size(min = 3, max = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Positive
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
