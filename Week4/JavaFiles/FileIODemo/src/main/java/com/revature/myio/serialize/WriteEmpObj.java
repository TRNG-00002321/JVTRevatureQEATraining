package com.revature.myio.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteEmpObj {
    public static void main(String[] args) {
        Employee employee = new Employee(101, "John Smith", "1234 Street Drive", "QEA");

        try (FileOutputStream fos = new FileOutputStream("employee.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
