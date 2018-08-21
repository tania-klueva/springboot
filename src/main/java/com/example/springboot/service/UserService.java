package com.example.springboot.service;

import com.example.springboot.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> findAll();
    Optional<User> findById(int id);
    void deleteById(int id);
    void save(User user);
}
