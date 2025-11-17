package com.revature.employee;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class EmployeeManager {
    public static void main(String[] args) {
        HashMap<Employee, Double> employees = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String user_input = getUserInput(scanner);

        do {
            if (user_input.equals("s")) {
                String id = getEmployeeId(scanner);
                scanner.nextLine();
                String name = getEmployeeName(scanner);
                double pay = getEmployeePay(scanner);
                int days = getSalariedDaysPresent(scanner);
                scanner.nextLine();
                String[] benefits = getSalariedBenefits(scanner);

                SalariedEmployee sEmp = new SalariedEmployee(id, name, pay, days, benefits);
                employees.put(sEmp, sEmp.calculateSalary());
            }
            else if (user_input.equals("c")) {
                String id = getEmployeeId(scanner);
                scanner.nextLine();
                String name = getEmployeeName(scanner);
                double pay = getEmployeePay(scanner);
                int hours = getContractedHoursWorked(scanner);
                scanner.nextLine();

                ContractedEmployee cEmp = new ContractedEmployee(id, name, pay, hours);
                employees.put(cEmp, cEmp.calculateSalary());
            }
            else {
                System.out.println("Input not recognized.");
            }
            user_input = getUserInput(scanner);
            scanner.nextLine();
        } while (!user_input.equals("quit"));

        System.out.println("\nSalaries: ");
        for (Map.Entry<Employee, Double> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + ", Salary: " + entry.getValue());
        }
    }

    public static String getUserInput(Scanner scanner) {
        System.out.println("What kind of employee do you wish to add?");
        System.out.println("(S for Salaried, C for Contracted)");
        System.out.print("Enter an option: ");

        return scanner.next().toLowerCase();
    }

    public static String getEmployeeId(Scanner scanner) {
        System.out.print("Enter this employee's ID: ");

        return scanner.next();
    }

    public static String getEmployeeName(Scanner scanner) {
        System.out.print("Enter this employee's name: ");

        return scanner.nextLine();
    }

    public static double getEmployeePay(Scanner scanner) {
        System.out.print("Enter this employee's hourly pay: ");

        return Math.abs(scanner.nextDouble());
    }

    public static int getSalariedDaysPresent(Scanner scanner) {
        System.out.print("Enter the amount of days this employee was present for: ");

        return Math.abs(scanner.nextInt());
    }

    public static String[] getSalariedBenefits(Scanner scanner) {
        System.out.print("Enter this employee's benefits: ");

        return scanner.nextLine().strip().toLowerCase().split(", ");
    }

    public static int getContractedHoursWorked(Scanner scanner) {
        System.out.print("Enter the amount of hours worked: ");

        return Math.abs(scanner.nextInt());
    }
}
