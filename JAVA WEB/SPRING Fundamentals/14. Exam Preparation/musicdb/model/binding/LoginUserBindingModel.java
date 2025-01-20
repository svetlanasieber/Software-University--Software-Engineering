package com.example.musicdb.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginUserBindingModel {

    @NotBlank
    @Size(min=3,max=20,message = "Length must be between 3 and 20 characters")
    private String username;

    @NotBlank
    @Size(min=4,max=20,message = "Length must be between 5 and 20 characters")
    private String password;

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

    public LoginUserBindingModel() {
    }

}
