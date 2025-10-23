package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

public class DealershipImportDto {

    @Expose
    @Size(min = 3, max = 30)
    private String name;

    @Expose
    @Size(min = 5)
    private String description;

    public DealershipImportDto() {
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
}