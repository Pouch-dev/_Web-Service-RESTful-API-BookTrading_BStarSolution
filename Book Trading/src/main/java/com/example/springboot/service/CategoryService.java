package com.example.springboot.service;

import com.example.springboot.entity.Category;
import com.example.springboot.model.AddCategory;
import com.example.springboot.model.UpdateCategory;

import java.util.List;

public interface CategoryService {
    List<Category> getListCategories();

    Category createCategory(AddCategory category);

    Category updateCategory(UpdateCategory category);

    Category getCategory(Integer categoryId);

    void deleteById(Integer categoryId);
}
