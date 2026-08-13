package com.interview.practice.lld.atm.state;

import com.interview.practice.lld.atm.model.ATM;
import com.interview.practice.lld.atm.model.Card;

public class IdleState implements ATMState {
    @Override
    public void insertCard(ATM atm, String cardNumber) {
        Card card = atm.findCard(cardNumber);
        if (card == null) {
            throw new IllegalArgumentException("Invalid card");
        }
        atm.setCurrentCard(card);
        atm.setState(new CardInsertedState());
        System.out.println("Card inserted: " + card.getCardNumber());
    }
}
