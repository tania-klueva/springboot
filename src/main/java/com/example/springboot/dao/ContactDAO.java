package com.example.springboot.dao;

import com.example.springboot.entity.Contact;
import com.example.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDAO extends JpaRepository<Contact, Integer> {
    List<Contact> findContactsByUserId(int id);
}
