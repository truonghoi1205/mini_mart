package com.example.mini_mart.repositories.category;

import com.example.mini_mart.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryRepo {
    List<Category> selectAll() throws SQLException;

    void createCate(Category category) throws  SQLException;

    void deleteCategory(int id) throws SQLException;

    Category findById(int id) throws SQLException;

    void updateCategory(Category category) throws SQLException;
}
