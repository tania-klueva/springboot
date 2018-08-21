package com.example.springboot.controllers;

import com.example.springboot.entity.Contact;
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

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}/contacts")
    private String userContacts(
            @PathVariable int id,
            Model model
    ){
        List<Contact> contacts = contactService.findContactsByUserId(id);
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
        model.addAttribute("contacts", contacts);
        model.addAttribute("id", id);
        return "contacts";
    }
    @PostMapping("/user/{id}/contacts")
    private String saveContact(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String number
    ){
        User user = userService.findById(id).get();
        Contact contact = new Contact(name, surname, number, user);
        contactService.save(contact);
        return "redirect:/user/{id}/contacts";
    }
    @GetMapping("/user/{id}/contacts/{contId}")
    private String userContactById(
            @PathVariable int contId,
            @PathVariable int id,
            Model model
    ){
        Contact contact = contactService.findById(contId).get();
        model.addAttribute("contact", contact);
        model.addAttribute("id", id);
        return "contact";
    }

    @PostMapping("/user/{id}/contacts/{contId}")
    private String userContactByIdupdate(
            @PathVariable int contId,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String number
    ){
        Contact contact = contactService.findById(contId).get();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setNumber(number);
        contactService.save(contact);
        return "redirect:/user/{id}/contacts";
    }

    @GetMapping("/user/{id}/contacts/{contId}/delete")
    private String userContactByIdDelete(
            @PathVariable int contId,
            @PathVariable int id
    ){
        contactService.deleteById(contId);
        return "redirect:/";
    }



}
