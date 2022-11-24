package com.example.demo.service;


import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User getUserById(long id);

    void saveUser(User user);

    void updateUserById(String name, String lastName, byte age, long id);

    void removeUserById(long id);

    List<User> getAllUsers();
}
