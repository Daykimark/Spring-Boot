package com.example.demo.service;


import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    void saveUser(User user);

    void updateUserById(String name, String lastName, Byte age, Long id);

    void removeUserById(Long id);

    List<User> getAllUsers();
}
