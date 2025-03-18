package softuni.exam.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AttractionImportDTO {

    @NotNull
    @Size(min = 5, max = 40)
    private String name;

    @NotNull
    @Size(min = 10, max = 100)
    private String description;

    @NotNull
    @Size(min = 3, max = 30)
    private String type;

    @NotNull
    @Min(value = 0)
    private Double elevation;

    @NotNull
    private Integer country;

    public AttractionImportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getElevation() {
        return elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }
} 