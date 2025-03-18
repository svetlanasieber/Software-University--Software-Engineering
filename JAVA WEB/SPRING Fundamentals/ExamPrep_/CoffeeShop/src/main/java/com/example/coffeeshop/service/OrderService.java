package com.example.coffeeshop.service;

import com.example.coffeeshop.model.service.OrderServiceAddModel;
import com.example.coffeeshop.model.view.OrdersViewModel;

import java.util.List;

public interface OrderService {

    OrderServiceAddModel addOrder(OrderServiceAddModel orderServiceAddModel);

    List<OrdersViewModel> findAllOrders();

    Integer getTotalTimeToPrepareOrders();

    void readyOrder(Long id);
}
