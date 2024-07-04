package com.example.mini_mart.services.user;

import com.example.mini_mart.models.User;
import com.example.mini_mart.repositories.user.IUserRePo;
import com.example.mini_mart.repositories.user.UserRePo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserService implements IUserService {
    IUserRePo userRePo = new UserRePo();
    @Override
    public List<User> selectAll() {
        try {
            return userRePo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUser(User user) {
        try {
            userRePo.createUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            userRePo.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(int id) {
        try {
            return userRePo.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            userRePo.updateUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findByName(String name) {
        try {
            return userRePo.findByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
