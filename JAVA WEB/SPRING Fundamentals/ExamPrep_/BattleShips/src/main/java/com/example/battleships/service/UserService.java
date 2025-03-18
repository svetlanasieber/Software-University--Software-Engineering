package com.example.battleships.service;

import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.UserLoginServiceModel;
import com.example.battleships.model.service.UserRegisterServiceModel;

public interface UserService {

    void registerUser(UserRegisterServiceModel userRegisterServiceModel);

    UserLoginServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id);

    User findUserById(Long id);

}
