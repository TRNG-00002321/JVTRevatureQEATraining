package com.revature.manager;

import org.sqlite.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;

public class ManagerJDBCM {
    private static final String DEFAULT_DB = "jdbc:mysql://localhost:3306/expensesystem";
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "password";

    private Connection connection;
    private String dbFilePath;
    private String dbUser;
    private String dbPass;

    public ManagerJDBCM(){
        Properties properties = new Properties();
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream("managerConfig.properties"))) {
            properties.load(input);
            this.dbFilePath = properties.getProperty("database.url", DEFAULT_DB);
            this.dbUser = properties.getProperty("database.username", DEFAULT_USER);
            this.dbPass = properties.getProperty("database.password", DEFAULT_PASSWORD);
        } catch (IOException e) {
            System.err.println("Error reading database properties: " + e.getMessage());
            this.dbFilePath = DEFAULT_DB;
            this.dbUser = DEFAULT_USER;
            this.dbPass = DEFAULT_PASSWORD;
        }
        this.setConnection();
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = this.dbFilePath;
            this.connection = DriverManager.getConnection(url, this.dbUser, this.dbPass);
            System.out.println("Connection to MySQL database established successfully.");
        } catch (SQLException e) {
            System.err.println("Error connecting to MySQL database: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.err.println("Error closing MySQL database connection: " + e.getMessage());
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

    public Manager verifyLogin(String uName, String pwd) throws NullPointerException, IllegalArgumentException {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?;";
        List<User> users = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, uName);
            pstmt.setString(2, pwd);
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
            System.err.println("Error querying MySQL database connection: " + e.getMessage());
        }

        for (User e : users){
            if (e.getName().equals(uName) && e.getPassword().equals(pwd)) {
                if (e.isManager()) {
                    return (Manager) e;
                }
                else {
                    throw new IllegalArgumentException("User is not a manager.");
                }
            }
        }

        throw new NullPointerException();
    }

    public List<Expense> getAllExpenses() {
        String sql = "SELECT e.id, e.user_id, e.amount, e.description, e.date FROM expenses AS e JOIN approvals AS a ON e.id = a.expense_id;";
        List<Expense> expenses = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int expenseId = rs.getInt("id");
                int userId = rs.getInt("user_id");
                double amount = rs.getDouble("amount");
                String desc = rs.getString("description");
                String dateString = rs.getString("date");
                LocalDate date = LocalDate.parse(dateString);

                expenses.add(new Expense(expenseId, userId, amount, desc, date));
            }
        } catch (SQLException e) {
            System.err.println("Error querying MySQL database connection: " + e.getMessage());
        }

        return expenses;
    }

    public List<Expense> getPendingExpenses() {
        String sql = "SELECT e.id, e.user_id, e.amount, e.description, e.date FROM expenses AS e JOIN approvals AS a ON e.id = a.expense_id WHERE a.status = ?;";
        List<Expense> pendingExpenses = new ArrayList<>();

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
            System.err.println("Error querying MySQL database connection: " + e.getMessage());
        }

        return pendingExpenses;
    }

    public int approveExpense(int approvalId, int reviewerId, String comment) {
        LocalDate reviewDate = LocalDate.now();
        String sql = "UPDATE approvals SET status = ?, reviewer = ?, comment = ?, review_date = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "approved");
            pstmt.setInt(2, reviewerId);
            pstmt.setString(3, comment);
            pstmt.setString(4, reviewDate.toString());
            pstmt.setInt(5, approvalId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error querying MySQL database connection: " + e.getMessage());
        }

        return -1;
    }

    public int denyExpense(int approvalId, int reviewerId, String comment) {
        LocalDate reviewDate = LocalDate.now();
        String sql = "UPDATE approvals SET status = ?, reviewer = ?, comment = ?, review_date = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "denied");
            pstmt.setInt(2, reviewerId);
            pstmt.setString(3, comment);
            pstmt.setString(4, reviewDate.toString());
            pstmt.setInt(5, approvalId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error querying MySQL database connection: " + e.getMessage());
        }

        return -1;
    }
}
