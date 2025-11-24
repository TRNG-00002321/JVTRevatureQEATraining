package com.revature.daodemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    static Connection conn = null;

    public static Connection dbConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
