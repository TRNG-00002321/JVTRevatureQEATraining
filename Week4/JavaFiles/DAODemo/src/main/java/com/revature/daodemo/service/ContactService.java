package com.revature.daodemo.service;

import com.revature.daodemo.model.Contact;
import java.util.List;

public interface ContactService {
    public List<Contact> getAllContacts();
    public Contact getContact(int id);
    public void save(Contact contact);
    public Contact update(int id);
    public void delete(int id);
}
