package com.example.l05_springdataintro.services;


import com.example.l05_springdataintro.models.Account;
import com.example.l05_springdataintro.models.User;
import com.example.l05_springdataintro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void register(String username, int age) {

        if (username.isBlank() || age < 18){
            throw new RuntimeException("Validation failed. Please filled correct information!");
        }

        Optional<User> byUsername = this.userRepository.findByUsername(username);

        if (byUsername.isPresent()){
            throw new RuntimeException("Username already exist!");
        }

        Account account = new Account();
        User user = new User(username, age, account);
        this.userRepository.save(user);
        //Add default account???
        //Save user


    }
}
