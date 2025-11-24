package com.revature.daodemo.dao;

import com.revature.daodemo.util.ConnectionUtil;
import com.revature.daodemo.model.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactJDBCImpl implements ContactDAO {
    Connection conn = null;

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
}
