package com.example.coffeeshop.model.view;

public class OrdersByEmployeeViewModel {

    private String employee;
    private Integer countOfOrders;

    public OrdersByEmployeeViewModel() {
    }

    public String getEmployee() {
        return employee;
    }

    public OrdersByEmployeeViewModel setEmployee(String employee) {
        this.employee = employee;
        return this;
    }

    public Integer getCountOfOrders() {
        return countOfOrders;
    }

    public OrdersByEmployeeViewModel setCountOfOrders(Integer countOfOrders) {
        this.countOfOrders = countOfOrders;
        return this;
    }
}
