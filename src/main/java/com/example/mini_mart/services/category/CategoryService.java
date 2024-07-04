package com.example.mini_mart.services.category;

import com.example.mini_mart.models.Category;
import com.example.mini_mart.repositories.category.CategoryRepo;
import com.example.mini_mart.repositories.category.ICategoryRepo;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepo categoryRepo = new CategoryRepo();

    @Override
    public List<Category> selectAll() {
        return categoryRepo.selectAll();
    }
}
