package com.example.mini_mart.repositories.category;

import com.example.mini_mart.models.Category;

import java.util.List;

public interface ICategoryRepo {
    List<Category> selectAll();
}
