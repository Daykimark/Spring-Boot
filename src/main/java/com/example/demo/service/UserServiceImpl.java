package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;

    @Override
    public User getUserById(long id) {
        return dao.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        dao.save(user);
    }

    @Override
    public void updateUserById(String name, String lastName, byte age, long id) {
        dao.updateUserById(name, lastName, age, id);
    }

    @Override
    public void removeUserById(long id) {
        dao.delete(dao.findById(id).get());
    }

    @Override
    public List<User> getAllUsers() {
        return dao.findAll();
    }
}
