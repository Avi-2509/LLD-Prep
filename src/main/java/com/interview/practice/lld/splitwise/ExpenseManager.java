package com.interview.practice.lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class ExpenseManager {
    private static final ExpenseManager INSTANCE = new ExpenseManager();

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Group> groups = new HashMap<>();
    private final BalanceSheet balanceSheet = new BalanceSheet();

    private ExpenseManager() {
    }

    public static ExpenseManager getInstance() {
        return INSTANCE;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addGroup(Group group) {
        groups.put(group.getId(), group);
    }

    public void addExpense(Expense expense) {
        SplitStrategy strategy = getStrategy(expense.getSplitType());
        strategy.validate(expense.getAmount(), expense.getSplits());
        strategy.apply(expense.getAmount(), expense.getSplits());

        for (Split split : expense.getSplits()) {
            if (!split.getUser().equals(expense.getPaidBy())) {
                if (expense.getGroup() != null) {
                    balanceSheet.addGroupBalance(
                            expense.getGroup().getId(),
                            split.getUser().getId(),
                            expense.getPaidBy().getId(),
                            split.getAmount()
                    );
                } else {
                    balanceSheet.addBalance(split.getUser().getId(), expense.getPaidBy().getId(), split.getAmount());
                }
            }
        }
    }

    public void showBalances() {
        boolean hasBalance = false;
        for (Map.Entry<String, Double> entry : balanceSheet.getBalances().entrySet()) {
            if (Math.abs(entry.getValue()) > 0.01) {
                hasBalance = true;
                User user = users.get(entry.getKey());
                System.out.println((user != null ? user.getName() : entry.getKey()) + " -> " + String.format("%.2f", entry.getValue()));
            }
        }
        if (!hasBalance) {
            System.out.println("No balances");
        }
    }

    public void showBalances(String groupId) {
        Group group = groups.get(groupId);
        if (group == null) {
            System.out.println("Group not found");
            return;
        }

        boolean hasBalance = false;
        for (Map.Entry<String, Double> entry : balanceSheet.getBalances().entrySet()) {
            if (!entry.getKey().startsWith(groupId + ":")) {
                continue;
            }
            if (Math.abs(entry.getValue()) > 0.01) {
                hasBalance = true;
                String userId = entry.getKey().substring(groupId.length() + 1);
                User user = users.get(userId);
                System.out.println(group.getName() + " | " + (user != null ? user.getName() : userId) + " -> " + String.format("%.2f", entry.getValue()));
            }
        }
        if (!hasBalance) {
            System.out.println(group.getName() + " | No balances");
        }
    }

    private SplitStrategy getStrategy(ExpenseSplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualSplitStrategy();
            case EXACT -> new ExactSplitStrategy();
            case PERCENT -> new PercentSplitStrategy();
        };
    }
}
