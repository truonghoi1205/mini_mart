package com.example.mini_mart.services.category;

import com.example.mini_mart.models.Category;
import com.example.mini_mart.repositories.category.CategoryRepo;
import com.example.mini_mart.repositories.category.ICategoryRepo;

import java.sql.SQLException;
import java.util.List;

public class
CategoryService implements ICategoryService {
    private ICategoryRepo categoryRepo = new CategoryRepo();

    @Override
    public List<Category> selectAll() {
        try {
            return categoryRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createCate(Category category) {
        try {
            categoryRepo.createCate(category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCategory(int id) {
        try {
            categoryRepo.deleteCategory(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category findById(int id) {
        try {
            return categoryRepo.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCategory(Category category) {
        try {
            categoryRepo.updateCategory(category);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> findByName(String name) {
        try {
            return categoryRepo.findByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
