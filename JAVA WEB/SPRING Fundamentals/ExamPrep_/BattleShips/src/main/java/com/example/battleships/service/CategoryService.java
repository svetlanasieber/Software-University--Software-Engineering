package com.example.battleships.service;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findCategoryByNameEnum(CategoryNameEnum category);

}
