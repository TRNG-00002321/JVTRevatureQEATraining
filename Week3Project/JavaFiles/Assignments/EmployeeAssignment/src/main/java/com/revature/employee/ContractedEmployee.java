package com.revature.employee;

public class ContractedEmployee extends Employee{
    private int hoursWorked;

    public ContractedEmployee() {
    }

    public ContractedEmployee(String id, String name, double pay) {
        super(id, name, pay);
        this.hoursWorked = 0;
    }

    public ContractedEmployee(String id, String name, double pay, int hours) {
        super(id, name, pay);
        this.hoursWorked = hours;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return getPay() * this.hoursWorked;
    }

    @Override
    public String toString() {
        return "ContractedEmployee{" +
                "hoursWorked=" + hoursWorked +
                "} " + super.toString();
    }
}
