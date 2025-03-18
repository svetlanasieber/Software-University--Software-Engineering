package com.example.battleships.service.impl;

import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.UserLoginServiceModel;
import com.example.battleships.model.service.UserRegisterServiceModel;
import com.example.battleships.repository.UserRepository;
import com.example.battleships.service.UserService;
import com.example.battleships.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public void registerUser(UserRegisterServiceModel userRegisterServiceModel) {
        User user = modelMapper.map(userRegisterServiceModel, User.class);

        userRepository.save(user);
    }

    @Override
    public UserLoginServiceModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserLoginServiceModel.class))
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
}
