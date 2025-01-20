package com.example.musicdb.service;

import com.example.musicdb.model.entity.UserEntity;
import com.example.musicdb.model.service.loginUserService;
import com.example.musicdb.model.service.registerUserService;

import java.util.Optional;

public interface UserService {
     boolean isExisting(String username, String password);

     void loginUser(loginUserService map);

     void registerUser(registerUserService map);

     UserEntity findById(Long id);

     void logout();
}
