package com.example.mini_mart.services.category;

import com.example.mini_mart.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> selectAll();
    void createCate(Category category);
    void deleteCategory(int id);

    Category findById(int id);

    void updateCategory(Category category);

    List<Category> findByName(String name);
}
