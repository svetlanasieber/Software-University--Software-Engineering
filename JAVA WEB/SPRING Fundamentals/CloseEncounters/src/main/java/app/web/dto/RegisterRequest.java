package app.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 4, max = 20, message = "Username must be at least 4 characters")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 4, max = 20, message = "Password must be at least 4 characters")
    private String password;
}