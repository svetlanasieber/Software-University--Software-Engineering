package softuni.exam.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CountryImportDTO {

    @NotNull
    @Size(min = 3, max = 40)
    private String name;

    @Min(value = 0)
    private Double area;

    public CountryImportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
} 