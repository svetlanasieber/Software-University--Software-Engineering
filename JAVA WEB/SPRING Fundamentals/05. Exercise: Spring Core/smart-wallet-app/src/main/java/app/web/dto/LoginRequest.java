package app.web.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {

    @Size(min = 6, message = "Username must be at least 6 characters")
    private String username;
    @Pattern(regexp = "\\d{6}", message = "Password must be exactly 6 digits")
    private String password;
}
