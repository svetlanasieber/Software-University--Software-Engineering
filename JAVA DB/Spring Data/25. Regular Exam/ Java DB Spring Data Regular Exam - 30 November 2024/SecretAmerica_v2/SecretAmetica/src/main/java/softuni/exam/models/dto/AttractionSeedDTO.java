package softuni.exam.models.dto;

import jakarta.validation.constraints.*;

public class AttractionSeedDTO {

    private String description;
    private int elevation;
    private String name;
    private String type;
    private Long country;
    private Long visitor;

    @NotNull
    @Size(min = 5, max = 40)
    public String getName() {
        return name;
    }

    @Size(min = 10, max = 100)
        public String getDescription() {
        return description;
    }

    @NotNull
    @Size(min = 3, max = 30)
    public String getType() {
        return type;
    }


    @PositiveOrZero
    public int getElevation() {
        return elevation;
    }

    public Long getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Long getVisitor() {
        return visitor;
    }

    public void setVisitor(Long visitor) {
        this.visitor = visitor;
    }
}
