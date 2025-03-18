package com.example.battleships.model.view;

public class ShipsViewModel {

    private Long id;
    private String name;
    private Integer health;
    private Integer power;

    public ShipsViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHealth() {
        return health;
    }

    public ShipsViewModel setHealth(Integer health) {
        this.health = health;
        return this;
    }

    public Integer getPower() {
        return power;
    }

    public ShipsViewModel setPower(Integer power) {
        this.power = power;
        return this;
    }
}
