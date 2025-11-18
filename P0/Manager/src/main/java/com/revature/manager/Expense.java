package com.revature.manager;

import java.time.LocalDate;

public class Expense {
    private int id;
    private int user;
    private double amount;
    private String description;
    private LocalDate date;

    public Expense() {
    }

    public Expense(int id, int user, double amount, String desc, LocalDate date) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.description = desc;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", user=" + user +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
