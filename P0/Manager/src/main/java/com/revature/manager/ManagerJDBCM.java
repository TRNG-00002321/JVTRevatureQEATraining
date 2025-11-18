package com.revature.manager;

import org.sqlite.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/*
TODO
[X] Log in securely so that I can access and manage employee expense reports.
[X] View a list of all pending expenses so that I can review them efficiently.
[] Approve or deny submitted expenses so that I can manage reimbursements appropriately.
[] Add comments to expense decisions so that employees understand the reasoning behind approvals or denials.
[] Generate reports by employee, category, or date so that I can analyze spending trends and make informed decisions.
 */

public class ManagerJDBCM {
    private Connection connection;
    private String dbFilePath;

    public ManagerJDBCM(){
        this.dbFilePath = "../expenses_database.db";
        this.setConnection();
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void setConnection() {
        try {
            // Load the SQLite JDBC driver (optional for modern JDBC, but good practice)
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:" + this.dbFilePath;
            this.connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite database established successfully.");
        } catch (SQLException e) {
            System.err.println("Error connecting to SQLite database: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing SQLite database connection: " + e.getMessage());
        }
    }

    public String getDbFilePath() {
        return this.dbFilePath;
    }

    public void setDbFilePath(String newFilePath) {
        this.dbFilePath = newFilePath;
        closeConnection();
        setConnection();
    }

    public boolean verifyLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?;";
        List<User> users = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String user = rs.getString("username");
                String pass = rs.getString("password");
                String role = rs.getString("role");

                if (role.equals("Employee")) {
                    Employee emp = new Employee(id, user, pass, role);
                    users.add(emp);
                }
                else {
                    Manager man = new Manager(id, user, pass, role);
                    users.add(man);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error querying SQLite database connection: " + e.getMessage());
        }

        for (User e : users){
            if (e.getName().equals(username) && e.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public List<Expense> getPendingExpenses() {
        String sql = "SELECT e.id, e.user_id, e.amount, e.description, e.date FROM expenses AS e JOIN approvals AS a ON e.id = a.expense_id WHERE a.status = ?;";
        List<Expense> pendingExpenses = new ArrayList<>();
        // SELECT e.id, e.user_id, e.amount, e.description, e.date
        //        FROM expenses AS e
        //        JOIN approvals AS a ON e.id = a.expense_id
        //        WHERE a.status = ?;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "pending");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int expenseId = rs.getInt("id");
                int userId = rs.getInt("user_id");
                double amount = rs.getDouble("amount");
                String desc = rs.getString("description");
                String dateString = rs.getString("date");
                LocalDate date = LocalDate.parse(dateString);

                pendingExpenses.add(new Expense(expenseId, userId, amount, desc, date));
            }
        } catch (SQLException e) {
            System.out.println("Error querying SQLite database connection: " + e.getMessage());
        }

        return pendingExpenses;
    }

    public void approveExpense(int expenseId, int reviewerId, String comment, LocalDate reviewDate) {
        //
    }

    public void denyExpense(int expenseId, int reviewerId, String comment, LocalDate reviewDate) {
        //
    }
}
