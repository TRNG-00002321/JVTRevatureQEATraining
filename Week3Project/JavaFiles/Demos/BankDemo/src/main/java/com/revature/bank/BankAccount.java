package com.revature.bank;

public abstract class BankAccount {
    private String accountId;
    private String accountName;
    private double balance;

    public BankAccount(){
    }

    public BankAccount(String id, String name, double amount){
        this.accountId = id;
        this.accountName = name;
        this.balance = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amt) {
        this.balance = amt;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public double deposit(double amt){
        setBalance(balance + amt);
        return balance;
    }

    public abstract double withdraw(double amt);
}
