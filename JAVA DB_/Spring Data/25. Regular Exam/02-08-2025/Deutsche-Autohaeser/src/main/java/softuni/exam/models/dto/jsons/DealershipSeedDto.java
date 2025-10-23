package softuni.exam.models.dto.jsons;

import com.google.gson.annotations.Expose;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public class DealershipSeedDto implements Serializable {

    @Expose
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @Expose
    @NotBlank
    @Size(min = 5)
    private String description;

    public DealershipSeedDto() {}

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