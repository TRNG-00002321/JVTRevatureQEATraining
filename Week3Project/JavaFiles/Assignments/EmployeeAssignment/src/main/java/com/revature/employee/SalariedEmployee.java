package com.revature.employee;

import java.util.Arrays;

public class SalariedEmployee extends Employee{
    private int daysPresent;
    private String []benefits;

    private static final int HOURS_IN_DAY = 8;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String id, String name, double pay) {
        super(id, name, pay);
        this.daysPresent = 0;
        this.benefits = new String[0];
    }

    public SalariedEmployee(String id, String name, double pay, int numDays, int numBenefits) {
        super(id, name, pay);
        this.daysPresent = numDays;
        this.benefits = new String[numBenefits];
    }

    public SalariedEmployee(String id, String name, double pay, int numDays, String... benefits) {
        super(id, name, pay);
        this.daysPresent = numDays;
        this.benefits = new String[benefits.length];
        System.arraycopy(benefits, 0, this.benefits, 0, benefits.length);
    }

    public int getDaysPresent() {
        return daysPresent;
    }

    public void setDaysPresent(int daysPresent) {
        this.daysPresent = daysPresent;
    }

    public String[] getBenefits() {
        return benefits;
    }

    @Override
    public double calculateSalary(){
        return getPay() * HOURS_IN_DAY * this.daysPresent;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "daysPresent=" + daysPresent +
                ", benefits=" + Arrays.toString(benefits) +
                "} " + super.toString();
    }
}
