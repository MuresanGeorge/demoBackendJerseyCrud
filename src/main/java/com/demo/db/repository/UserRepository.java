package com.demo.db.repository;

import com.demo.model.User;

import java.util.List;

public interface UserRepository {
    void createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
}
