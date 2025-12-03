package com.revature.manager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
TODO
[X] Log in securely so that I can access and manage employee expense reports.
[X] View a list of all pending expenses
[X] Approve or deny submitted expenses
[X] Add comments to expense decisions
[X] Generate reports by employee, category, or date
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
        while (true) {
            System.out.print("\nSelect an approval (enter its ID): ");
            userSelection = scanner.nextInt();
            if (approvalIds.contains(userSelection)) {
                break;
            } else {
                logger.error("Unable to select an approval (invalid id).");
            }
        }
        scanner.nextLine(); // Flush the scanner's buffer

        return userSelection;
    }

    public static String getComment() {
        String userComment;
        while (true) {
            System.out.print("\nEnter comment: ");
            userComment = scanner.nextLine();
            if (userComment.isBlank()) {
                logger.error("Illegal argument passed as approval comment.");
            } else {
                break;
            }
        }
        return userComment;
    }

    public static void approve(Manager m) {
        int id = selectApproval();
        String comment = getComment();
        if (dbManager.approveExpense(id, m.getId(), comment) > 0) {
            logger.info("Expense approved (approval ID: {}) by manager {} (user ID: {}).", id, m.getName(), m.getId());
        } else {
            logger.error("Expense approval failed. (approval ID: {}, manager / user ID: {})", id, m.getId());
        }
    }

    public static void deny(Manager m) {
        int id = selectApproval();
        String comment = getComment();
        if (dbManager.denyExpense(id, m.getId(), comment) > 0) {
            logger.info("Expense denied (approval ID: {}) by manager {} (user ID: {}).", id, m.getName(), m.getId());
        } else {
            logger.error("Expense denial failed. (approval ID: {}, manager / user ID: {})", id, m.getId());
        }
    }

    public static void reportByEmployee(Manager m) {
        String header = "====== EXPENSE REPORT ======";
        List<Expense> expenses = dbManager.getAllExpenses();
        TreeMap<Integer, Double> employeeTotals = new TreeMap<>(
                expenses.stream().collect(
                        Collectors.groupingBy(Expense::getUser,
                                Collectors.summingDouble(Expense::getAmount)
                        ))
        );
        System.out.println(header);
        for (Map.Entry<Integer, Double> e : employeeTotals.entrySet()) {
            System.out.printf("Employee ID: %-4d, Expense Total: $%-10.2f%n", e.getKey(), e.getValue());
        }
        for (int i = 0; i < header.length(); i++) {
            System.out.print('=');
        }
        System.out.println('\n');
        logger.info("Manager (user ID: {}) generated a by-employee expense report.", m.getId());
    }

    public static void reportByCategory(Manager m) {
        String header = "====== EXPENSE REPORT ======";
        List<Expense> expenses = dbManager.getAllExpenses();
        TreeMap<String, Double> categoryTotals = new TreeMap<>(
                expenses.stream().collect(
                Collectors.groupingBy(Expense::getDescription,
                        Collectors.summingDouble(Expense::getAmount)
                ))
        );
        System.out.println(header);
        for (Map.Entry<String, Double> e : categoryTotals.entrySet()) {
            System.out.printf("Category: %-50s| Expense Total: $%-10.2f%n", e.getKey(), e.getValue());
        }
        for (int i = 0; i < header.length(); i++) {
            System.out.print('=');
        }
        System.out.println('\n');
        logger.info("Manager (user ID: {}) generated a by-category expense report.", m.getId());
    }

    public static void reportByDate(Manager m) {
        String header = "====== EXPENSE REPORT ======";
        List<Expense> expenses = dbManager.getAllExpenses();
        TreeMap<LocalDate, Double> dateTotals = new TreeMap<>(
                expenses.stream().collect(
                        Collectors.groupingBy(Expense::getDate,
                                Collectors.summingDouble(Expense::getAmount)
                        ))
        );
        System.out.println(header);
        for (Map.Entry<LocalDate, Double> e : dateTotals.entrySet()) {
            System.out.printf("Date: %-12s, Expense Total: $%-10.2f%n", e.getKey(), e.getValue());
        }
        for (int i = 0; i < header.length(); i++) {
            System.out.print('=');
        }
        System.out.println('\n');
        logger.info("Manager (user ID: {}) generated a by-date expense report.", m.getId());
    }

    public static void generateReport(Manager m) {
        String[] reportOptions = {"employee", "category", "date"};
        String header = "========= REPORT TYPES =========";
        String reportTypeSelection = "";
        boolean isValidReportType = false;

        while (!isValidReportType) {
            System.out.println(header);
            for (int i = 0; i < reportOptions.length; i++) {
                System.out.println((i + 1) + ". Report by " + reportOptions[i]);
            }
            for (int i = 0; i < header.length(); i++) {
                System.out.print('=');
            }
            System.out.print("\nSelect a report type: ");
            reportTypeSelection = scanner.nextLine();
            switch (reportTypeSelection.trim()) {
                case "1":
                case "employee":
                    reportByEmployee(m);
                    isValidReportType = true;
                    break;
                case "2":
                case "category":
                    reportByCategory(m);
                    isValidReportType = true;
                    break;
                case "3":
                case "date":
                    reportByDate(m);
                    isValidReportType = true;
                    break;
                default:
                    logger.error("Invalid report type selected.");
            }
        }
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
