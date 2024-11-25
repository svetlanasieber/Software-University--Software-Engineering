package org.example.product_shop.services.impl;

import org.example.product_shop.entities.users.User;
import org.example.product_shop.entities.users.UserWithSoldProductDTO;
import org.example.product_shop.repositories.UserRepository;
import org.example.product_shop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public List<UserWithSoldProductDTO> getUsersWithSoldProducts() {
        List<User> allWithSoldProducts = this.userRepository.findAllWithSoldProducts();

        return allWithSoldProducts.stream()
                .map(user -> this.modelMapper.map(user, UserWithSoldProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<User> getUsersWithSoldProductsOrderByCount() {
        List<User> all = this.userRepository.findAllWithSoldProductsOrderByCount();

        all.get(0).getSellingItems().size();
    }
}
