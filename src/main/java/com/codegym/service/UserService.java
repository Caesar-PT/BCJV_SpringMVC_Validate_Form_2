package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User findById(int id);

    User add(User user);

    void del(User user);

}
