package app.web.dto;

import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @Size(min = 4, max = 20, message = "Username must be at least 4 characters")
    private String username;

    @Size(min = 4, max = 20, message = "Password must be at least 4 characters")
    private String password;

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
} 