package com.revature.daodemo.service;

import com.revature.daodemo.dao.ContactDAO;
import com.revature.daodemo.dao.ContactJDBCImpl;
import com.revature.daodemo.model.Contact;

public class ContactServiceImpl implements ContactService {
    ContactDAO contactDAO = new ContactJDBCImpl();

    @Override
    public Contact getContact(int id) {
        return contactDAO.getContact(id);
    }
}
