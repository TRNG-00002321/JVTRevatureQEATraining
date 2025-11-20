package com.revature.manager;

import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
TODO
[X] Log in securely so that I can access and manage employee expense reports.
[X] View a list of all pending expenses
[] Approve or deny submitted expenses
[] Add comments to expense decisions
[] Generate reports by employee, category, or date
 */

public class ManagerApp {
    public static final Logger logger = LoggerFactory.getLogger(ManagerApp.class);
    public static final Scanner scanner = new Scanner(System.in);
    public static ManagerJDBCM dbManager = new ManagerJDBCM();

    public static Manager login() {
        Manager current;
        while (true) {
            System.out.print("Enter username: ");
            String name = scanner.nextLine();
            System.out.print("Enter password: ");
            String pass = scanner.nextLine();

            try {
                current = dbManager.verifyLogin(name, pass);
                break;
            } catch (NullPointerException e) {
                logger.error("Invalid login. Wrong username or password.");
            } catch (IllegalArgumentException e) {
                logger.error(e.getMessage());
            }
        }
        logger.info("User {} ({}) logged in.", current.getId(), current.getName());
        return current;
    }

    public static List<Expense> viewPending() {
        List<Expense> pendingExpenses = dbManager.getPendingExpenses();

        System.out.printf("| %10s | %7s | %10s | %-50s | %-10s |%n", "Expense ID", "User ID", "Amount", "Description", "Date");
        System.out.println("|------------+---------+------------+----------------------------------------------------+------------|");
        for (Expense e : pendingExpenses) {
            System.out.printf("| %10d | %7d | %10.2f | %-50s | %-10s |%n", e.getId(), e.getUser(), e.getAmount(), e.getDescription(), e.getDate());
        }
        System.out.println("|------------+---------+------------+----------------------------------------------------+------------|");

        return pendingExpenses;
    }

    public static int selectApproval() {
        List<Integer> approvalIds = viewPending().stream().map(Expense::getId).toList();
        int userSelection = -1;
        // TODO Prompt user to enter an int; if user input is a valid approval ID, return it; otherwise, log error & loop.

        return userSelection;
    }

    public static void approve(Manager m) {
        int id = selectApproval();
        //
    }

    public static void deny(Manager m) {
        int id = selectApproval();
        //
    }

    public static void reportByEmployee(Manager m) {
        //
    }

    public static void reportByCategory(Manager m) {
        //
    }

    public static void reportByDate(Manager m) {
        //
    }

    public static void generateReport(Manager m) {
        //
    }

    public static void quit() {
        logger.info("Closing connection to database...");
        dbManager.closeConnection();
        logger.info("Database connection closed.");
        logger.info("Quitting application.");
    }

    public static void main(String[] args) {
        Manager current = login();
        String userInput = "";
        String header = "========= ACTIONS =========";
        String[] options = {"View pending expenses", "Approve an expense", "Deny an expense", "Generate an expense report", "Quit"};

        while (!userInput.equals("5")) {
            System.out.println(header);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            for (int i = 0; i < header.length(); i++) {
                System.out.print('=');
            }
            System.out.println();

            System.out.print("Enter menu option (number): ");
            userInput = scanner.nextLine().toLowerCase();
            System.out.println();

            switch (userInput) {
                case "1":
                    viewPending();
                    logger.info("User {} ({}) viewed pending expenses.", current.getId(), current.getName());
                    break;
                case "2":
                    approve(current);
                    break;
                case "3":
                    deny(current);
                    break;
                case "4":
                    generateReport(current);
                    break;
                case "5":
                    break;
                default:
                    logger.error("Current user entered an invalid menu option.");
                    break;
            }
        }

        quit();
    }
}
