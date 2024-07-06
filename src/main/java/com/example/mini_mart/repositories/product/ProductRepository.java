package com.example.mini_mart.repositories.product;

import com.example.mini_mart.database.ConnectDB;
import com.example.mini_mart.models.Category;
import com.example.mini_mart.models.Product;
import com.example.mini_mart.models.dto.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProductRepository implements IProductRepository {
    @Override
    public List<ProductDTO> selectAll() {
        List<ProductDTO> products = new ArrayList<>();
        try {
            Connection connection = new ConnectDB().getConnection();
            String sql = "select p.id, p.avatar, p.sku, p.name, p.cost_price, p.price, p.description, p.quantity, c.name as category_name " +
                    "from products p " +
                    "join categories c on p.category_id = c.id";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setId(rs.getInt("id"));
                product.setAvatar(rs.getString("avatar"));
                product.setSku(rs.getString("sku"));
                product.setName(rs.getString("name"));
                product.setCostPrice(rs.getDouble("cost_price"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setQuantity(rs.getInt("quantity"));
                product.setCategoryName(rs.getString("category_name"));
                products.add(product);
            }
            rs.close();
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Product product) {
        Connection connection = new ConnectDB().getConnection();
        String sql = "insert into products (sku, name, price, description, avatar, cost_price, quantity, category_id) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, randomNumber());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getDescription());
            ps.setString(5, product.getAvatar());
            ps.setDouble(6, product.getCostPrice());
            ps.setInt(7, product.getQuantity());
            ps.setInt(8, product.getCategoryId());
            ;
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteById(int id) {
        Connection connection = new ConnectDB().getConnection();
        String sql = "delete from products where id = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product selectById(int id) {
        Product product = null;
        Connection connection = new ConnectDB().getConnection();
        String sql = "select p.*, c.name as categoryName from products p join categories c on p.category_id = c.id where p.id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String avatar = rs.getString("avatar");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                double costPrice = rs.getDouble("cost_price");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("category_id");
                Category category = new Category();
                category.setId(categoryId);
                category.setName(rs.getString("categoryName"));
                product = new Product(id, sku, name, price, description, avatar, costPrice, quantity, category);
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        Connection connection = new ConnectDB().getConnection();
        String sql = "update products set sku = ?, name = ?, price = ?, description = ?, avatar = ?, cost_price = ?, quantity = ?, category_id = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getSku());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getDescription());
            ps.setString(5, product.getAvatar());
            ps.setDouble(6, product.getCostPrice());
            ps.setInt(7, product.getQuantity());
            ps.setInt(8, product.getCategoryId());
            ps.setInt(9, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) {
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from products where category_id = ?";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setSku(rs.getString("sku"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setAvatar(rs.getString("avatar"));
                product.setCostPrice(rs.getDouble("cost_price"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public List<Product> searchProductsByApproximatePrice(double price) {
        List<Product> products = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from products where price <= ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, price);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setSku(rs.getString("sku"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setAvatar(rs.getString("avatar"));
                product.setCostPrice(rs.getDouble("cost_price"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public List<Product> selectProductByCategoryId(int categoryId) {
        List<Product> products = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from products where category_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setSku(rs.getString("sku"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setAvatar(rs.getString("avatar"));
                product.setCostPrice(rs.getDouble("cost_price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setCategoryId(rs.getInt("category_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    private String randomNumber() {
        Random r = new Random(System.currentTimeMillis());
        int n = 0 + r.nextInt(10000);
        return "SP-" + n;
    }
}
