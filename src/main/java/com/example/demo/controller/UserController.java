package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {
    @Autowired
    UserService service;

    @GetMapping(value = "/")
    public String printUsers(ModelMap map) {
        map.addAttribute("users", service.getAllUsers());
        return "homePage";
    }

    @GetMapping("/newPerson")
    public String newPerson(Model model) {
        model.addAttribute("person", new User());
        return "newPerson";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("person", service.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("person") User user) {
        service.saveUser(user);
        return "redirect:/";
    }

    @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id") long id) {

        service.updateUserById(user.getName(), user.getLastName(), user.getAge(), id);
        return "redirect:/";
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        service.removeUserById(id);
        return "redirect:/";
    }
}
