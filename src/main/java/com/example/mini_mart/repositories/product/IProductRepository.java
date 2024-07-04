package com.example.mini_mart.repositories.product;

import com.example.mini_mart.models.Product;
import com.example.mini_mart.models.dto.ProductDTO;

import java.util.List;

public interface IProductRepository {
    List<ProductDTO> selectAll();

    void insert(Product product);
}
