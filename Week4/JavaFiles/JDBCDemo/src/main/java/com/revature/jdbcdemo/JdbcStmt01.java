package com.revature.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcStmt01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        // STEP 1. Load the driver -- OPTIONAL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // STEP 2. Create the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2", "root", "pass");
            // STEP 3. Create the statement object
            stmt = conn.createStatement();
            String query = "select * from contacts";
            // STEP 4. Execute the query and collect the result in result set
            rs = stmt.executeQuery(query);
            // STEP 5. Process the ResultSet
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " , " + rs.getString(2).toUpperCase() + " , " + rs.getString("email"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Database connected...");
    }
}
