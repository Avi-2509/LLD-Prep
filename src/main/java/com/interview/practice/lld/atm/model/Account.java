package com.interview.practice.lld.atm.model;

public class Account {
    private final String accountNumber;
    private final String pin;
    private double balance;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isPinValid(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount) {
        this.balance -= amount;
    }
}
