package com.example.mini_mart.services.user;

import com.example.mini_mart.models.User;

import java.util.List;

public interface IUserService {
    List<User> selectAll();

    void createUser(User user);

    void deleteUser(int id);

    User findById(int id);

    void updateUser(User user);

    List<User> findByName(String name);
}
