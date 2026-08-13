package com.interview.practice.lld.atm.model;

import com.interview.practice.lld.atm.state.ATMState;
import com.interview.practice.lld.atm.state.IdleState;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private final Map<String, Account> accountStore = new HashMap<>();
    private final Map<String, Card> cardStore = new HashMap<>();
    private ATMState state;
    private Card currentCard;
    private Account currentAccount;
    private Operation selectedOperation;

    public ATM() {
        this.state = new IdleState();
    }

    public void addAccount(Account account) {
        accountStore.put(account.getAccountNumber(), account);
    }

    public void addCard(Card card) {
        cardStore.put(card.getCardNumber(), card);
    }

    public void insertCard(String cardNumber) {
        state.insertCard(this, cardNumber);
    }

    public void enterPin(String pin) {
        state.enterPin(this, pin);
    }

    public void selectOperation(Operation operation) {
        state.selectOperation(this, operation);
    }

    public void withdraw(double amount) {
        state.withdraw(this, amount);
    }

    public void ejectCard() {
        state.ejectCard(this);
    }

    public Card findCard(String cardNumber) {
        return cardStore.get(cardNumber);
    }

    public Account findAccount(String accountNumber) {
        return accountStore.get(accountNumber);
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setSelectedOperation(Operation selectedOperation) {
        this.selectedOperation = selectedOperation;
    }

    public Operation getSelectedOperation() {
        return selectedOperation;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public ATMState getState() {
        return state;
    }

    public void clearSession() {
        currentCard = null;
        currentAccount = null;
        selectedOperation = null;
    }
}
