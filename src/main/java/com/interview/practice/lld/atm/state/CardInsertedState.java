package com.interview.practice.lld.atm.state;

import com.interview.practice.lld.atm.model.ATM;
import com.interview.practice.lld.atm.model.Account;
import com.interview.practice.lld.atm.model.Card;

public class CardInsertedState implements ATMState {
    @Override
    public void enterPin(ATM atm, String pin) {
        Card card = atm.getCurrentCard();
        if (card == null) {
            throw new IllegalStateException("No card inserted");
        }
        Account account = atm.findAccount(card.getAccountNumber());
        if (account == null || !account.isPinValid(pin)) {
            throw new IllegalArgumentException("Invalid PIN");
        }
        atm.setCurrentAccount(account);
        atm.setState(new PinVerifiedState());
        System.out.println("PIN verified");
    }
}
