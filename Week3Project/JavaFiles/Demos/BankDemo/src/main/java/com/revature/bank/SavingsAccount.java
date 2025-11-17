package com.revature.bank;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(){
    }

    public SavingsAccount(String id, String name, double amount){
        super(id, name, amount);
    }

    @Override
    public String toString() {
        return "SavingsAccount{ " + super.toString() + " }";
    }

    @Override
    public double withdraw(double amt) {
        super.setBalance(getBalance() - amt);
        return getBalance();
    }
}
