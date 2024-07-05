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

    @Override
    public void createCate(Category category) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "Insert into categories(name,avatar,description) value (?,?,?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, category.getName());
        ps.setString(2, category.getAvatar());
        ps.setString(3, category.getDescription());
        ps.executeUpdate();
    }

    @Override
    public void deleteCategory(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = " delete From categories where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

    }

    @Override
    public Category findById(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "Select * From categories where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            category.setAvatar(rs.getString("avatar"));
            return category;
        } else {
            return null;
        }

    }

    @Override
    public void updateCategory(Category category) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "update categories set name = ?,  avatar = ? ,description = ? where id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, category.getName());
        ps.setString(2, category.getAvatar());
        ps.setString(3, category.getDescription());
        ps.setInt(4, category.getId());
        ps.executeUpdate();
    }
}
