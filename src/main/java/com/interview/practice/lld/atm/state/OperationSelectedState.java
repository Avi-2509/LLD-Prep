package com.interview.practice.lld.atm.state;

import com.interview.practice.lld.atm.model.ATM;

public class OperationSelectedState implements ATMState {
    @Override
    public void withdraw(ATM atm, double amount) {
        if (atm.getCurrentAccount() == null) {
            throw new IllegalStateException("No account selected");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (atm.getCurrentAccount().getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        atm.getCurrentAccount().debit(amount);
        atm.setState(new TransactionCompletedState());
        System.out.println("Cash dispensed: " + amount);
    }
}
