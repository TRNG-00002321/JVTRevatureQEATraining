package com.revature.jdbcdemo;

import java.sql.*;

public class JdbcPSDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2", "root", "pass");
            String query = "insert into contacts(name, email, phone) values(?, ?, ?);";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "Jasdhir");
            pstmt.setString(2, "jasdhir1@email.com");
            pstmt.setString(3, "123457890");
            pstmt.execute(query);
            pstmt.close();

            String selectquery = "select * from contacts where name like ?";
            pstmt = conn.prepareStatement(selectquery);
            pstmt.setString(1, "Perry");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " , " + rs.getString(2).toUpperCase() + " , " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Database connected...");
    }
}
