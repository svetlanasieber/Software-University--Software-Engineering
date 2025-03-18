package com.example.coffeeshop.model.view;

import com.example.coffeeshop.model.entity.Category;

import java.math.BigDecimal;

public class OrdersViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;

    public OrdersViewModel() {
    }

    public Long getId() {
        return id;
    }

    public OrdersViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrdersViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrdersViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public OrdersViewModel setCategory(Category category) {
        this.category = category;
        return this;
    }
}
