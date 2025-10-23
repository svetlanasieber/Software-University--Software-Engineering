package main.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.House;
import main.model.WizardAlignment;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    @NotBlank
    @Size(min = 6, max = 12)
    private String username;

    @NotBlank
    @Pattern(regexp = "^\\d{6}$")
    private String password;

    @NotBlank
    @URL
    private String avatarUrl;

    @NotNull
    private House house;

    @NotNull
    private WizardAlignment alignment;
}

