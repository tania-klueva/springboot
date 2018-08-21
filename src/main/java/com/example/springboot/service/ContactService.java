package com.example.springboot.service;

import com.example.springboot.entity.Contact;
import com.example.springboot.entity.User;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAll();
    List<Contact> findContactsByUserId(int id);
    Optional<Contact> findById(int id);
    void deleteById(int id);
    void save(Contact contact);
}
