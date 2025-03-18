package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.entity.Order;
import com.example.coffeeshop.model.service.OrderServiceAddModel;
import com.example.coffeeshop.model.view.OrdersViewModel;
import com.example.coffeeshop.repository.OrderRepository;
import com.example.coffeeshop.service.CategoryService;
import com.example.coffeeshop.service.OrderService;
import com.example.coffeeshop.service.UserService;
import com.example.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public OrderServiceAddModel addOrder(OrderServiceAddModel orderServiceAddModel) {

        Order order = modelMapper.map(orderServiceAddModel, Order.class)
                .setCategory(categoryService.findCategoryByNameEnum(orderServiceAddModel.getCategory()))
                .setEmployee(userService.findUserById(currentUser.getId()));

        return modelMapper.map(orderRepository.save(order), OrderServiceAddModel.class);
    }

    @Override
    public List<OrdersViewModel> findAllOrders() {
        return orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrdersViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getTotalTimeToPrepareOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> order.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
