package com.example.mini_mart.services.product;

import com.example.mini_mart.models.Product;
import com.example.mini_mart.models.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> selectAll();

    void insert(Product product);

    void deleteById(int id);

    Product selectProductById(int id);

    void updateProduct(Product product);

    List<Product> getProductByCategoryId(int categoryId);

    List<Product> searchProductsByApproximatePrice(int price);
    List<Product> selectProductByCategoryId(int category_id);
}
