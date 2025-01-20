package com.example.musicdb.service.impl;

import com.example.musicdb.model.entity.UserEntity;
import com.example.musicdb.model.service.loginUserService;
import com.example.musicdb.model.service.registerUserService;
import com.example.musicdb.repository.UserRepository;
import com.example.musicdb.service.UserService;
import com.example.musicdb.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isExisting(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) == null;
    }

    @Override
    public void loginUser(loginUserService map) {
        currentUser.setUsername(map.getUsername());
        currentUser.setId(userRepository.findByUsernameAndPassword(map.getUsername(), map.getPassword()).getId());

    }

    @Override
    public void registerUser(registerUserService registerUserService) {
        userRepository.save(modelMapper.map(registerUserService, UserEntity.class));
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }
}
