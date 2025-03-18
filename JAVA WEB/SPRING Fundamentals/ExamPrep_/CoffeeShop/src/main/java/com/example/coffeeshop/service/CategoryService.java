package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.enums.CategoryNameEnum;

public interface CategoryService {

    void initCategory();

    Category findCategoryByNameEnum(CategoryNameEnum category);

}
