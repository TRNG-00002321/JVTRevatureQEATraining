package com.revature.bank;

public class BankManager {
    public static void main(String[] args) {
        // BankAccount acct1 = new BankAccount("B001", "Jasdhir", 1000);

        SavingsAccount savings1 = new SavingsAccount("S001", "Stephenie", 10000);
        System.out.println(savings1);

        CheckingAccount checking1 = new CheckingAccount("C001", "Jeremiah", 15000);
        System.out.println(checking1);

        try {
            savings1.deposit(6000);
            System.out.println(savings1);
            savings1.withdraw(500);
            checking1.withdraw(90000);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds.");
        }
        finally {
            try {
                checking1.withdraw(1000);
                savings1.deposit(-200);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println("Insufficient funds.");
            }
            finally {
                System.out.println(savings1);
                System.out.println(checking1);
            }
        }
    }
}
