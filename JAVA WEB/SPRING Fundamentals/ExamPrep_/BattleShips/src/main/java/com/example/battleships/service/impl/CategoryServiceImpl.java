package com.example.battleships.service.impl;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.enums.CategoryNameEnum;
import com.example.battleships.repository.CategoryRepository;
import com.example.battleships.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (categoryRepository.count() != 0) {
            return;
        }

        List<Category> categories = Arrays.stream(CategoryNameEnum.values())
                .map(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum)
                            .setDescription(String.format("info %s ...", categoryNameEnum.toString()));

                    return category;
                })
                .toList();

        categoryRepository.saveAll(categories);
    }

    @Override
    public Category findCategoryByNameEnum(CategoryNameEnum category) {
        return categoryRepository.findByName(category).orElse(null);
    }
}
