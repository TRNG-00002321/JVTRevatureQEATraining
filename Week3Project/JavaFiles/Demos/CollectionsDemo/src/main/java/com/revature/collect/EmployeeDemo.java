package com.revature.collect;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Lucy", 98532.17);
        Employee emp2 = new Employee(5, "Zachary", 1232.27);
        Employee emp3 = new Employee(3, "Anthony", 150000.00);
        Employee emp4 = new Employee(2, "Madeline", 794.99);
        Employee emp5 = new Employee(4, "Hector", 678324.56);
        List<Employee> emps = new ArrayList<>();
        emps.add(emp1);
        emps.add(emp5);
        emps.add(emp3);
        emps.add(emp2);
        emps.add(emp4);

        System.out.println(emps);

        Collections.sort(emps);
        System.out.println(emps);

        Collections.sort(emps, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println(emps);

        Collections.sort(emps, (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(emps);
    }
}
