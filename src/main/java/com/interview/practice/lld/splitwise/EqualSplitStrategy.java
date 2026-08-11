package com.interview.practice.lld.splitwise;

import java.util.List;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public void validate(double totalAmount, List<Split> splits) {
        if (splits == null || splits.isEmpty()) {
            throw new IllegalArgumentException("Splits cannot be empty");
        }
    }

    @Override
    public void apply(double totalAmount, List<Split> splits) {
        double share = totalAmount / splits.size();
        for (Split split : splits) {
            split.setAmount(share);
        }
    }
}
