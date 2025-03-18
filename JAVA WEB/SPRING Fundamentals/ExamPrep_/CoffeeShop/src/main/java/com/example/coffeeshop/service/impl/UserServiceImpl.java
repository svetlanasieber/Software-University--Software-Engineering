package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.entity.User;
import com.example.coffeeshop.model.service.UserServiceLoginModel;
import com.example.coffeeshop.model.service.UserServiceRegisterModel;
import com.example.coffeeshop.model.view.OrdersByEmployeeViewModel;
import com.example.coffeeshop.repository.UserRepository;
import com.example.coffeeshop.service.UserService;
import com.example.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public boolean registerUser(UserServiceRegisterModel userServiceRegisterModel) {
        User user = modelMapper.map(userServiceRegisterModel, User.class);

        try {
            userRepository.save(user);

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public UserServiceLoginModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceLoginModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id) {
        currentUser.setId(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrdersByEmployeeViewModel> findAllUsersAndCountOfOrders() {
        return userRepository
                .findAllByOrdersCountDesc()
                .stream()
                .map(user -> {
                    OrdersByEmployeeViewModel order = new OrdersByEmployeeViewModel();
                    order
                            .setEmployee(user.getUsername())
                            .setCountOfOrders(user.getOrders().size());

                    return order;
                })
                .collect(Collectors.toList());

    }
}
