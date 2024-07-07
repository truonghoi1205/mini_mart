package com.example.mini_mart.services.product;

import com.example.mini_mart.models.Product;
import com.example.mini_mart.models.dto.ProductDTO;
import com.example.mini_mart.repositories.product.IProductRepository;
import com.example.mini_mart.repositories.product.ProductRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<ProductDTO> selectAll() {
        return productRepository.selectAll();
    }

    @Override
    public void insert(Product product) {
        productRepository.insert(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product selectProductById(int id) {
        return productRepository.selectById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) {
        return productRepository.getProductByCategoryId(categoryId);
    }

    @Override
    public List<Product> searchProductsByApproximatePrice(int price) {
        return productRepository.searchProductsByApproximatePrice(price);
    }

    @Override
    public List<Product> selectProductByCategoryId(int category_id) {
        return productRepository.selectProductByCategoryId(category_id);
    }

    @Override
    public List<Product> getProducts(int page, int pageSize) {
        try {
            return productRepository.getProducts(page,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalProducts() {
        try {
            return productRepository.getTotalProducts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
