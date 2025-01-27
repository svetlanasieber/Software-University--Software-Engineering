package com.softuni.http.service;

import com.softuni.http.model.Product;
import com.softuni.http.repository.ProductRepository;
import com.softuni.http.web.dto.UpsertProductRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Example with POST request
    public Product create(UpsertProductRequest request) {

        Product product = Product.builder()
                .name(request.getName())
                .quantity(request.getQuantity())
                .build();

        return productRepository.save(product);
    }

    // Example with PATCH request
    public Product updateQuantity(Long productId, int newQuantity) {

        Product product = productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);
        product.setQuantity(newQuantity);

        return productRepository.save(product);
    }

    // Example with DELETE request
    public void delete(Long productId) {

        productRepository.deleteById(productId);
    }

    // Example with GET (all) request
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    // Example with GET (all) request
    public Product getProductById(Long id) {

        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    // Example with PUT request
    public Product updateProductDetails(Long id, UpsertProductRequest request) {

        Product product = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        product.setName(request.getName());
        product.setQuantity(request.getQuantity());

        return productRepository.save(product);
    }
}
