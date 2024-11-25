package org.example.product_shop.services;

import org.example.product_shop.entities.categories.CategoryStats;
import org.example.product_shop.entities.products.Product;
import org.example.product_shop.entities.products.ProductWithoutBuyerDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductWithoutBuyerDTO> getProductsInPriceRangeForSell(float from, float to);

    List<CategoryStats> getCategoryStatistics();
}
