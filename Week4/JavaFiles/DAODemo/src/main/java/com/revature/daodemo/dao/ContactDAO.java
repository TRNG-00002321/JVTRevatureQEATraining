package com.revature.daodemo.dao;

import com.revature.daodemo.model.Contact;
import java.util.List;

public interface ContactDAO {
    public default List<Contact> getAllContacts() {
        return null;
    }
    public default Contact getContact(int id) {
        return null;
    }
    public default void save(Contact contact) {
        //
    }
    public default Contact update(int id) {
        return null;
    }
    public default void delete(int id) {
        //
    }
}
