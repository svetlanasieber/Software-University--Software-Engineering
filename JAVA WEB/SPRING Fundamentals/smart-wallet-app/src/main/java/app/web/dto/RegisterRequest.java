package app.web.dto;

import app.user.model.Country;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @Size(min = 6, message = "Username must be at least 6 characters")
    private String username;

    @Pattern(regexp = "\\d{6}", message = "Password must be exactly 6 digits")
    private String password;

    private Country country;
}
