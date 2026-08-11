package com.interview.practice.lld.splitwise;

import java.util.List;

public class ExactSplitStrategy implements SplitStrategy {
    @Override
    public void validate(double totalAmount, List<Split> splits) {
        double sum = 0;
        for (Split split : splits) {
            sum += split.getAmount();
        }
        if (Math.abs(sum - totalAmount) > 0.01) {
            throw new IllegalArgumentException("Exact split amounts must sum to total amount");
        }
    }

    @Override
    public void apply(double totalAmount, List<Split> splits) {
        // already provided by caller
    }
}
