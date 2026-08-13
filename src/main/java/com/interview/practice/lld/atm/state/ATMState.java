package com.interview.practice.lld.atm.state;

import com.interview.practice.lld.atm.model.ATM;
import com.interview.practice.lld.atm.model.Operation;

public interface ATMState {
    default void insertCard(ATM atm, String cardNumber) {
        throw new IllegalStateException("Operation not allowed in current state");
    }

    default void enterPin(ATM atm, String pin) {
        throw new IllegalStateException("Operation not allowed in current state");
    }

    default void selectOperation(ATM atm, Operation operation) {
        throw new IllegalStateException("Operation not allowed in current state");
    }

    default void withdraw(ATM atm, double amount) {
        throw new IllegalStateException("Operation not allowed in current state");
    }

    default void ejectCard(ATM atm) {
        throw new IllegalStateException("Operation not allowed in current state");
    }
}
