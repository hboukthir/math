package org.example;

public class BankAccount {
    private double balance;

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds or invalid amount");
        }
    }

    public double getBalance() {
        return balance;
    }
}