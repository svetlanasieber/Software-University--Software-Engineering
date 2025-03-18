package com.example.coffeeshop.model.service;

public class UserServiceRegisterModel {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserServiceRegisterModel() {
    }

    public Long getId() {
        return id;
    }

    public UserServiceRegisterModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceRegisterModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserServiceRegisterModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserServiceRegisterModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceRegisterModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceRegisterModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
