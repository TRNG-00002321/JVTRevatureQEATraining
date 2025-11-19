package com.revature.streamapi;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class StreamAssignment {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("E001", "Jeff", 29000.55));
        emps.add(new Employee("E002", "John", 96000.84));
        emps.add(new Employee("E003", "Jay", 2500.03));
        emps.add(new Employee("E004", "Richard", 1290.11));
        emps.add(new Employee("E005", "Susan", 88000.88));
        emps.add(new Employee("E006", "Rebecca", 9900.00));
        emps.add(new Employee("E007", "Joanne", 4900.60));
        emps.add(new Employee("E008", "Zachary", 20000.95));
        emps.add(new Employee("E009", "Zack", 6700.76));
        emps.add(new Employee("E010", "Jody", 69000.59));

        // Display employees using an enhanced for loop
        for (Employee e : emps) {
            System.out.println(e);
        }

        System.out.println();

        // Display employees using a for all each loop
        // emps.forEach(emp -> System.out.println(emp));
        emps.forEach(System.out::println); // Equivalent to above statement

        System.out.println();

        // Return all employee names in uppercase using map()
        // List<String> names = emps.stream().map(emp -> emp.getName().toUpperCase()).collect(Collectors.toList());
        List<String> names = emps.stream().map(emp -> emp.getName().toUpperCase()).toList();
        names.forEach(System.out::println);

        System.out.println();

        // From the existing list, create a list of employees having salary more than 20,000 using filter()
        // List<Employee> filteredEmployees = emps.stream().filter(employee -> employee.getPay() > 20000.00).collect(Collectors.toList());
        List<Employee> filteredEmployees = emps.stream().filter(employee -> employee.getPay() > 20000.00).toList();
        filteredEmployees.forEach(employee -> System.out.println(employee.getName()));
        // emps.stream().filter(employee -> employee.getPay() > 20000.00).toList().forEach(employee -> System.out.println(employee.getName()));
    }
}
