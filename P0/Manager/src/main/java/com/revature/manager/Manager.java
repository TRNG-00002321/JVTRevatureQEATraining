package com.revature.manager;

public class Manager extends User{
    public Manager(int id, String name, String pass, String role)  throws IllegalArgumentException {
        if (!role.equals("Manager")) {
            throw new IllegalArgumentException("Invalid role");
        }
        super(id, name, pass, role);
    }

    @Override
    public boolean isManager() {
        return true;
    }

    @Override
    public boolean isEmployee() {
        return false;
    }
}
