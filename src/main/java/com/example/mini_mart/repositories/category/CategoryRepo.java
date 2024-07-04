package com.example.mini_mart.repositories.category;

import com.example.mini_mart.database.ConnectDB;
import com.example.mini_mart.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo {
    @Override
    public List<Category> selectAll() {
        List<Category> categories = new ArrayList();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from categories";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setAvatar(rs.getString("avatar"));
                category.setDescription(rs.getString("description"));
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
