package com.example.springboot.service.impl;

import com.example.springboot.dao.ContactDAO;
import com.example.springboot.entity.Contact;
import com.example.springboot.entity.User;
import com.example.springboot.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactDAO contactDAO;

    @Override
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

    @Override
    public List<Contact> findContactsByUserId(int id) {
        return contactDAO.findContactsByUserId(id);
    }

    @Override
    public Optional<Contact> findById(int id) {
        return contactDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        contactDAO.deleteById(id);
    }

    @Override
    public void save(Contact contact) {
        contactDAO.save(contact);
    }
}
