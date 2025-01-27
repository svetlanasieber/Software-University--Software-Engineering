package com.softuni.http.web;

import com.softuni.http.model.Product;
import com.softuni.http.service.ProductService;
import com.softuni.http.web.dto.UpsertProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        Product product = productService.getProductById(id);

        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProductQuantityById(@PathVariable Long id, @RequestParam int quantity) {

        Product updatedProduct = productService.updateQuantity(id, quantity);

        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long id, @RequestBody UpsertProductRequest request) {

        Product updatedProduct = productService.updateProductDetails(id, request);

        return ResponseEntity.ok(updatedProduct);
    }

    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody UpsertProductRequest request) {

        Product newProduct = productService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity.ok("Product with id [%s] successfully deleted.".formatted(id));
    }
}
