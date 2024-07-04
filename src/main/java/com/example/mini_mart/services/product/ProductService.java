package com.example.mini_mart.services.product;

import com.example.mini_mart.models.Product;
import com.example.mini_mart.models.dto.ProductDTO;
import com.example.mini_mart.repositories.product.IProductRepository;
import com.example.mini_mart.repositories.product.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<ProductDTO> selectAll() {
        return productRepository.selectAll();
    }
}
