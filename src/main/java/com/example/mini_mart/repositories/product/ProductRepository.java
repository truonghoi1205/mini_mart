package com.example.mini_mart.repositories.product;

import com.example.mini_mart.database.ConnectDB;
import com.example.mini_mart.models.Product;
import com.example.mini_mart.models.dto.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    @Override
    public List<ProductDTO> selectAll() {
        List<ProductDTO> products = new ArrayList<>();
        try {
            Connection connection = new ConnectDB().getConnection();
            String sql = "select p.id, p.avatar, p.sku, p.name, p.cost_price, p.price, c.description, p.quantity, c.name as category_name " +
                    "from products p " +
                    "join categories c on p.category_id = c.id";
            PreparedStatement satement = connection.prepareStatement(sql);
            ResultSet rs = satement.executeQuery();
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
            PreparedStatement satement = connection.prepareStatement(sql);
            satement.setString(1, product.getSku());
            satement.setString(2, product.getName());
            satement.setDouble(3, product.getPrice());
            satement.setString(4, product.getDescription());
            satement.setString(5, product.getAvatar());
            satement.setDouble(6, product.getCostPrice());
            satement.setInt(7, product.getQuantity());
            satement.setInt(8, product.getCategoryId());
            satement.executeUpdate();
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
}
