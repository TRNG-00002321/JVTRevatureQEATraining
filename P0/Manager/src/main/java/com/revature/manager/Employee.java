package com.revature.manager;

public class Employee extends User {
    public Employee(int id, String name, String pass, String role)  throws IllegalArgumentException {
        if (!role.equals("Employee")) {
            throw new IllegalArgumentException("Invalid role");
        }
        super(id, name, pass, role);
    }

    @Override
    public boolean isManager() {
        return false;
    }

    @Override
    public boolean isEmployee() {
        return true;
    }
}
