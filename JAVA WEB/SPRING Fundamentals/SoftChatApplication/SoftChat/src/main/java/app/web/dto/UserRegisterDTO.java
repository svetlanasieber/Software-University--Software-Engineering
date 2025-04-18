package app.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @NotBlank
    @Size(min = 4, max = 20, message = "Username must be at least 4 characters")
    private String username;

    @NotBlank
    @Size(min = 4, max = 20, message = "Password must be at least 4 characters")
    private String password;

    @NotBlank
    @Email(message = "Enter valid email address")
    private String email;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
} 