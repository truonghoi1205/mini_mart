package com.example.mini_mart.repositories.user;

import com.example.mini_mart.database.ConnectDB;
import com.example.mini_mart.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRePo implements IUserRePo {
    @Override
    public List<User> selectAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from user";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail((rs.getString("email")));
            user.setPassword(rs.getString("password"));
            users.add(user);
        }
        return users;
    }

    @Override
    public void createUser(User user) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "insert into user(name,email,password) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.execute();
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "delete from user where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    @Override
    public User findById(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from user where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail((rs.getString("email")));
            user.setPassword(rs.getString("password"));
            return user;
        } else {
            return null;
        }

    }

    @Override
    public void updateUser(User user) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "UPDATE user SET name = ?, email = ?, password = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public List<User> findByName(String name) throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from user where name like ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,"%" + name + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            users.add(user);
        }
        return users;
    }

}
