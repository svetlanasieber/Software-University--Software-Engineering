package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.enums.CategoryNameEnum;
import com.example.coffeeshop.repository.CategoryRepository;
import com.example.coffeeshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategory() {

        if (categoryRepository.count() != 0) {
            return;
        }

        List<Category> categories = Arrays.stream(CategoryNameEnum.values())
                .map(categoryNameEnum -> new Category()
                        .setName(categoryNameEnum)
                        .setNeededTime(setTimeForCategory(categoryNameEnum)))
                .toList();

        categoryRepository.saveAll(categories);
    }

    private Integer setTimeForCategory(CategoryNameEnum categoryNameEnum) {
        return switch (categoryNameEnum) {
            case Drink -> 1;
            case Coffee -> 2;
            case Other -> 5;
            case Cake -> 10;
        };
    }

    @Override
    public Category findCategoryByNameEnum(CategoryNameEnum category) {
        return categoryRepository.findByName(category).orElse(null);
    }

}
