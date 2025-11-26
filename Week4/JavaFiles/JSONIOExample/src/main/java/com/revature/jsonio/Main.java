package com.revature.jsonio;

import com.revature.jsonio.model.Employee;
import com.revature.jsonio.model.Student;
import com.revature.jsonio.service.EmployeeService;
import java.io.File;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        File employeeJson = new File("employees.json");
        File studentJson = new File("students.json");

        Employee emp1 = new Employee(101, "Jerry Dingdoo", "1234 Street Drive", "Worker");
        Employee emp2 = new Employee(104, "Jadie Vance", "2478 Wow Blvd", "Programmer");
        Employee emp3 = new Employee(107, "Paul Salto", "9878 Wilson Street", "Constructor");
        Employee emp4 = new Employee(231, "Zeffery Williams", "1378 Stool Dr", "Imploder");
        Employee emp5 = new Employee(963, "Lingar Pingar", "3674 Mustard Way", "Licker");

        Student s1 = new Student(251844, "Larry Sue", 3.673);
        Student s2 = new Student(987322, "Mary Doog", 4.0);
        Student s3 = new Student(513667, "Kendrick Pamar", 3.367);
        Student s4 = new Student(881626, "The Sufferer", 1.967);

        EmployeeService empService = new EmployeeService();
        empService.save(emp1);
        empService.save(emp2);
        empService.save(emp3);
        empService.save(emp4);
        empService.save(emp5);

        List<Employee> emps = empService.getAll();
        for (Employee emp : emps) {
            System.out.println(emp);
        }

        Optional<Employee> test = empService.get(101);
        System.out.println(test.orElse(new Employee(0, "Michael McDoesn't-Exist", "XXXX Not Real Street", "None")));

        //
    }
}
