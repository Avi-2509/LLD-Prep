package com.interview.practice.lld.splitwise;

public abstract class Split {
    private final User user;
    private double amount;

    protected Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
