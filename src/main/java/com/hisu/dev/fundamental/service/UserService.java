package com.hisu.dev.fundamental.service;

import com.hisu.dev.fundamental.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getUserById(String id);

    boolean addUser(User newUser);
    boolean deleteUser(String id);
    boolean updateUser(User updateUser);
}
