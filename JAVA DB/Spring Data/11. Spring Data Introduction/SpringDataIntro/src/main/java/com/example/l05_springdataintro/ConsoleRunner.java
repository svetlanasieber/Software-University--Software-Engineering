package com.example.l05_springdataintro;

import com.example.l05_springdataintro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.userService.register("Gosho", 33);
    }
}
