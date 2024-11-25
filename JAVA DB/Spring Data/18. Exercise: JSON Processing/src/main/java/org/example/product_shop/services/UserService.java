package org.example.product_shop.services;

import org.example.product_shop.entities.users.User;
import org.example.product_shop.entities.users.UserWithSoldProductDTO;

import java.util.List;

public interface UserService {
    List<UserWithSoldProductDTO> getUsersWithSoldProducts();

    List<User> getUsersWithSoldProductsOrderByCount();
}
