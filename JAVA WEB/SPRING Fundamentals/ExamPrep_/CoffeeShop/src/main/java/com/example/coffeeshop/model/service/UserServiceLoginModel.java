package com.example.coffeeshop.model.service;

public class UserServiceLoginModel {

    private Long id;
    private String username;
    private String password;

    public UserServiceLoginModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceLoginModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceLoginModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceLoginModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
