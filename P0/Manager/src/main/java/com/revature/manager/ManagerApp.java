package com.revature.manager;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
TODO
[] Log in securely so that I can access and manage employee expense reports.
[] View a list of all pending expenses
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
            }
            catch (NullPointerException e) {
                logger.error("Invalid login. Wrong username or password.");
            }
        }
        logger.info("User {} ({}) logged in.", current.getId(), current.getName());
        return current;
    }

    public static void viewPending() {
        //
    }

    public static void approve() {
        viewPending();
        //
    }

    public static void deny() {
        viewPending();
        //
    }

    public static void reportByEmployee() {
        //
    }

    public static void reportByCategory() {
        //
    }

    public static void reportByDate() {
        //
    }

    public static void generateReport() {
        //
    }

    public static void quit() {
        //
    }

    public static void main(String[] args) {
        Manager current = login();
        String userInput = "";
        String header = "========= ACTIONS =========";
        String[] options = {"View pending expenses", "Approve an expense", "Deny an expense", "Generate an expense report", "Quit"};

        while (!userInput.equals("quit")) {
            System.out.println(header);
            for (int i = 0; i < options.length; i++) {
                System.out.println(i + ". " + options[i]);
            }
            for (int i = 0; i < header.length(); i++) {
                System.out.print('=');
            }
            System.out.println();

            System.out.print("Enter menu option (number): ");
            userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "1":
                    viewPending();
                    break;
                case "2":
                    approve();
                    break;
                case "3":
                    deny();
                    break;
                case "4":
                    generateReport();
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
