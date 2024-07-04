package com.example.mini_mart.repositories.user;

import com.example.mini_mart.models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRePo {
    List<User> selectAll() throws SQLException;

    void createUser(User user) throws SQLException;

    void deleteUser(int id) throws SQLException;

    User findById(int id) throws SQLException;

    void updateUser(User user) throws SQLException;

    List<User> findByName(String name) throws  SQLException;

    User findUserByEmailAndPassword(String email, String password);
}
