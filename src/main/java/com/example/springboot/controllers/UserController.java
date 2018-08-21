package com.example.springboot.controllers;

import com.example.springboot.entity.User;
import com.example.springboot.service.ContactService;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public String main(
            Model model
    ){
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/")
    public String save(
            @RequestParam String name,
            @RequestParam String surname
    ){
        User user = new User(name, surname);
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String user(
            @PathVariable int id,
            Model model
    ){
        User user = userService.findById(id).get();
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/user/{id}")
    public String update(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String surname
    ){
        User user = userService.findById(id).get();
        user.setName(name);
        user.setSurname(name);
        userService.save(user);
        return "redirect:/user/{id}";
    }

    @GetMapping("/user/{id}/delete")
    public String userDelete(
            @PathVariable int id
    ){
        userService.deleteById(id);
        return "redirect:/";
    }
}
