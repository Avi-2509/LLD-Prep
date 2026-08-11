package com.interview.practice.lld.splitwise;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ExpenseManager manager = ExpenseManager.getInstance();

        User u1 = new User("u1", "Alice");
        User u2 = new User("u2", "Bob");
        User u3 = new User("u3", "Charlie");

        manager.addUser(u1);
        manager.addUser(u2);
        manager.addUser(u3);

        Group trip = new Group("g1", "Goa Trip");
        trip.addMember(u1);
        trip.addMember(u2);
        trip.addMember(u3);
        manager.addGroup(trip);

        Expense dinner = new Expense.Builder()
                .id("e1")
                .description("Dinner")
                .amount(900)
                .paidBy(u1)
                .group(trip)
                .splitType(ExpenseSplitType.EQUAL)
                .splits(List.of(new EqualSplit(u1), new EqualSplit(u2), new EqualSplit(u3)))
                .build();
        manager.addExpense(dinner);

        Expense cab = new Expense.Builder()
                .id("e2")
                .description("Cab")
                .amount(600)
                .paidBy(u2)
                .group(trip)
                .splitType(ExpenseSplitType.EXACT)
                .splits(List.of(
                        new ExactSplit(u1, 200),
                        new ExactSplit(u2, 100),
                        new ExactSplit(u3, 300)))
                .build();
        manager.addExpense(cab);

        Expense groceries = new Expense.Builder()
                .id("e3")
                .description("Groceries")
                .amount(1000)
                .paidBy(u3)
                .group(trip)
                .splitType(ExpenseSplitType.PERCENT)
                .splits(List.of(
                        new PercentSplit(u1, 50),
                        new PercentSplit(u2, 30),
                        new PercentSplit(u3, 20)))
                .build();
        manager.addExpense(groceries);

        manager.showBalances(trip.getId());
    }
}
