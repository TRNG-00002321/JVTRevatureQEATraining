package com.revature.daodemo;

import com.revature.daodemo.service.ContactServiceImpl;
import com.revature.daodemo.model.Contact;
import com.revature.daodemo.service.ContactService;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ContactService contactService = new ContactServiceImpl();
        Contact contact = contactService.getContact(2);
        System.out.println(contact);
    }
}
