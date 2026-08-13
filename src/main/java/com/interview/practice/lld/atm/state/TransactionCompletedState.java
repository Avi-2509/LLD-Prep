package com.interview.practice.lld.atm.state;

import com.interview.practice.lld.atm.model.ATM;

public class TransactionCompletedState implements ATMState {
    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Ejecting card: " + atm.getCurrentCard().getCardNumber());
        atm.clearSession();
        atm.setState(new IdleState());
    }
}
