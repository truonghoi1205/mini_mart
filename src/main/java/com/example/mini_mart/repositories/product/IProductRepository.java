package com.example.mini_mart.repositories.product;

import com.example.mini_mart.models.Product;
import com.example.mini_mart.models.dto.ProductDTO;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {
    List<ProductDTO> selectAll();

    void insert(Product product);

    void deleteById(int id);

    Product selectById(int id);

    void updateProduct(Product product);

    List<Product> getProductByCategoryId(int categoryId);

    List<Product> searchProductsByApproximatePrice(double price);

    List<Product> selectProductByCategoryId(int categoryId);

    List<Product> getProducts(int page, int pageSize) throws SQLException;

    int getTotalProducts() throws SQLException;


    List<ProductDTO> findByName(String name) throws SQLException;
}
