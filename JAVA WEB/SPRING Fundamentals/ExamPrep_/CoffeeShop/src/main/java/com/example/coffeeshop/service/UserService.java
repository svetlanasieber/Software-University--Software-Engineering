package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.User;
import com.example.coffeeshop.model.service.UserServiceLoginModel;
import com.example.coffeeshop.model.service.UserServiceRegisterModel;
import com.example.coffeeshop.model.view.OrdersByEmployeeViewModel;

import java.util.List;

public interface UserService {

    boolean registerUser(UserServiceRegisterModel userServiceRegisterModel);

    UserServiceLoginModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id);

    User findUserById(Long id);

    List<OrdersByEmployeeViewModel> findAllUsersAndCountOfOrders();

}
