package com.revature.daodemo.dao;

import com.revature.daodemo.util.ConnectionUtil;
import com.revature.daodemo.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactJDBCImpl implements ContactDAO {
    Connection conn = null;

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        conn = ConnectionUtil.dbConnection();
        String getAllContacts = "select * from contacts";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(getAllContacts);
            while (rs.next()) {
                Contact contact = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                contacts.add(contact);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contacts;
    }

    @Override
    public Contact getContact(int id) {
        Contact contact = null;
        conn = ConnectionUtil.dbConnection();
        String getContacts = "select * from contacts where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(getContacts);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                contact = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return contact;
    }

    @Override
    public void save(Contact contact) {
        String saveContact = "insert into contacts (name, email, phone) values (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(saveContact);
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3, contact.getPhone());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Contact update(int id) {
        Contact contact = getContact(id);
        String saveContact = "update contacts set name = ?, email = ?, phone = ? where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(saveContact);
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getEmail());
            pstmt.setString(3, contact.getPhone());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getContact(id);
    }

    @Override
    public void delete(int id) {
        String deleteContact = "delete from contacts where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(deleteContact);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
