package com.interview.practice.lld.splitwise;

import java.util.List;

public class Expense {
    private final String id;
    private final String description;
    private final double amount;
    private final User paidBy;
    private final Group group;
    private final List<Split> splits;
    private final ExpenseSplitType splitType;

    private Expense(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.amount = builder.amount;
        this.paidBy = builder.paidBy;
        this.group = builder.group;
        this.splits = builder.splits;
        this.splitType = builder.splitType;
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public User getPaidBy() { return paidBy; }
    public Group getGroup() { return group; }
    public List<Split> getSplits() { return splits; }
    public ExpenseSplitType getSplitType() { return splitType; }

    public static class Builder {
        private String id;
        private String description;
        private double amount;
        private User paidBy;
        private Group group;
        private List<Split> splits;
        private ExpenseSplitType splitType;

        public Builder id(String id) { this.id = id; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder amount(double amount) { this.amount = amount; return this; }
        public Builder paidBy(User paidBy) { this.paidBy = paidBy; return this; }
        public Builder group(Group group) { this.group = group; return this; }
        public Builder splits(List<Split> splits) { this.splits = splits; return this; }
        public Builder splitType(ExpenseSplitType splitType) { this.splitType = splitType; return this; }
        public Expense build() { return new Expense(this); }
    }
}
