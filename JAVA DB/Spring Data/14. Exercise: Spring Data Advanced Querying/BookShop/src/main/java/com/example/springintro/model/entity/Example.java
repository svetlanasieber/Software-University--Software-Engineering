package com.example.springintro.model.entity;

public class Example {
    private String firstName;
    private String lastName;
    private Long copies;

    public Example(String firstName, String lastName, Long copies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.copies = copies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
