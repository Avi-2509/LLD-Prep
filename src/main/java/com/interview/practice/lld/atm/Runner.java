package com.interview.practice.lld.atm;

import com.interview.practice.lld.atm.model.ATM;
import com.interview.practice.lld.atm.model.Account;
import com.interview.practice.lld.atm.model.Card;
import com.interview.practice.lld.atm.model.Operation;

public class Runner {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.addAccount(new Account("acc_101", "1234", 5000));
        atm.addCard(new Card("card_9001", "acc_101"));

        System.out.println("Step 1: Insert card");
        atm.insertCard("card_9001");

        System.out.println("Step 2: Enter PIN");
        atm.enterPin("1234");

        System.out.println("Step 3: Select operation");
        atm.selectOperation(Operation.WITHDRAW);

        System.out.println("Step 4: Withdraw money");
        atm.withdraw(1500);

        System.out.println("Step 5: Eject card");
        atm.ejectCard();
    }
}
