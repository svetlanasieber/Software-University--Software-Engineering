package com.example.battleships.model.binding;

import com.example.battleships.model.entity.enums.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipsAddBindingModel {

    private String name;
    private Integer health;
    private Integer power;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipsAddBindingModel() {
    }

    @Size(min = 2, max = 10, message = "Name length must be between 2 and 10 characters!")
    public String getName() {
        return name;
    }

    public ShipsAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @PositiveOrZero
    @NotNull(message = "Please enter value!")
    public Integer getHealth() {
        return health;
    }

    public ShipsAddBindingModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    @PositiveOrZero
    @NotNull(message = "Please enter value!")
    public Integer getPower() {
        return power;
    }

    public ShipsAddBindingModel setPower(Integer power) {
        this.power = power;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Cannot be in the future!")
    @NotNull
    public LocalDate getCreated() {
        return created;
    }

    public ShipsAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @NotNull(message = "Select category!")
    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipsAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
