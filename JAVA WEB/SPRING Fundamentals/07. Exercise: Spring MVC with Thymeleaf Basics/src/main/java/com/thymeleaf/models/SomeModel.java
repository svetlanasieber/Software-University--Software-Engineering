package com.thymeleaf.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SomeModel {

    @NotNull
    @Size(min = 3, max = 10, message = "Invalid name")
    private String name;

    public SomeModel(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
