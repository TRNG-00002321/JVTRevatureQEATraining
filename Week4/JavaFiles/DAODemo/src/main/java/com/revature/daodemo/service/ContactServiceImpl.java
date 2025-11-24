package com.revature.daodemo.service;

import com.revature.daodemo.dao.ContactDAO;
import com.revature.daodemo.dao.ContactJDBCImpl;
import com.revature.daodemo.model.Contact;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDAO contactDAO = new ContactJDBCImpl();

    @Override
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    @Override
    public Contact getContact(int id) {
        return contactDAO.getContact(id);
    }

    @Override
    public void save(Contact contact) {
        contactDAO.save(contact);
    }

    @Override
    public Contact update(int id) {
        return contactDAO.update(id);
    }

    @Override
    public void delete(int id) {
        contactDAO.delete(id);
    }
}
