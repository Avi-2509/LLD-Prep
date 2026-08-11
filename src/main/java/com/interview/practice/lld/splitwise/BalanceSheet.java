package com.interview.practice.lld.splitwise;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    private final Map<String, Double> balances = new HashMap<>();

    public void addBalance(String fromUserId, String toUserId, double amount) {
        balances.put(fromUserId, balances.getOrDefault(fromUserId, 0.0) - amount);
        balances.put(toUserId, balances.getOrDefault(toUserId, 0.0) + amount);
    }

    public Map<String, Double> getBalances() {
        return balances;
    }

    public void addGroupBalance(String groupId, String fromUserId, String toUserId, double amount) {
        String fromKey = groupId + ":" + fromUserId;
        String toKey = groupId + ":" + toUserId;
        balances.put(fromKey, balances.getOrDefault(fromKey, 0.0) - amount);
        balances.put(toKey, balances.getOrDefault(toKey, 0.0) + amount);
    }
}
