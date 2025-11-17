package com.revature.bank;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(){
    }

    public CheckingAccount(String id, String name, double amount) {
        super(id, name, amount);
    }

    @Override
    public String toString() {
        return "CheckingAccount{ " + super.toString() + " }";
    }

    @Override
    public double withdraw(double amount) throws ArithmeticException, InsufficientFundsException {
        if (amount < 0) {
            throw new ArithmeticException("Cannot withdraw a negative amount.");
        }
        else if (getBalance() - amount < 5000) {
            throw new InsufficientFundsException();
        }
        else {
            double surcharge = (amount * 0.01) / 100;
            amount += surcharge;
            super.setBalance(getBalance() - amount);
            return getBalance();
        }
    }
}
