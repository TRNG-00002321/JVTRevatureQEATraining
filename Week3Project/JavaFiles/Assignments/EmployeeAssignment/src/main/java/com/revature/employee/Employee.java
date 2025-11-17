package com.revature.employee;

public abstract class Employee {
    private String employeeId;
    private String name;
    private double pay;

    public Employee() {
    }

    public Employee(String id, String name, double pay) {
        this.employeeId = id;
        this.name = name;
        this.pay = pay;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", pay=" + pay +
                '}';
    }
}
