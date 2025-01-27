package com.softuni.http.init;

import com.softuni.http.model.Product;
import com.softuni.http.service.ProductService;
import com.softuni.http.web.dto.UpsertProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductInitializer implements CommandLineRunner {

    private final ProductService productService;

    @Autowired
    public ProductInitializer(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Product> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            return;
        }

        UpsertProductRequest apple = UpsertProductRequest.builder()
                .name("Apple")
                .quantity(10)
                .build();

        UpsertProductRequest kiwi = UpsertProductRequest.builder()
                .name("Kiwi")
                .quantity(4)
                .build();

        UpsertProductRequest strawberry = UpsertProductRequest.builder()
                .name("Strawberry")
                .quantity(12)
                .build();

        productService.create(apple);
        productService.create(kiwi);
        productService.create(strawberry);
    }
}
