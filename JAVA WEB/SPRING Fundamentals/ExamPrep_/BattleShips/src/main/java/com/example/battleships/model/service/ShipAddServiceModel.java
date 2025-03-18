package com.example.battleships.model.service;

import com.example.battleships.model.entity.enums.CategoryNameEnum;

import java.time.LocalDate;

public class ShipAddServiceModel {

    private Long id;
    private String name;
    private Integer health;
    private Integer power;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public ShipAddServiceModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public ShipAddServiceModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipAddServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipAddServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
