package com.example.musicdb.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class RegisterUserBindingModel {

    @NotBlank
    @Size(min = 3, max = 20,message = "Username length must be between 3 and 20 characters")
    private String username;

    @NotBlank
    @Size(min = 3, max = 20,message = "Full name length must be between 3 and 20 characters")
    private String fullName;

    @NotBlank
    @Size(min = 5, max = 20,message = "Password length must be between 5 and 20 characters")
    private String password;

    @Email
    private String email;


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @NotBlank
    @Size(min = 5, max = 20,message = "Password length must be between 5 and 20 characters")
    private String confirmPassword;


    public RegisterUserBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
