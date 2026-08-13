package com.interview.practice.lld.atm.state;

import com.interview.practice.lld.atm.model.ATM;
import com.interview.practice.lld.atm.model.Operation;

public class PinVerifiedState implements ATMState {
    @Override
    public void selectOperation(ATM atm, Operation operation) {
        atm.setSelectedOperation(operation);
        atm.setState(new OperationSelectedState());
        System.out.println("Operation selected: " + operation);
    }
}
