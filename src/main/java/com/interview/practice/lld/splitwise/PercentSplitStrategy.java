package com.interview.practice.lld.splitwise;

import java.util.List;

public class PercentSplitStrategy implements SplitStrategy {
    @Override
    public void validate(double totalAmount, List<Split> splits) {
        double sum = 0;
        for (Split split : splits) {
            if (!(split instanceof PercentSplit percentSplit)) {
                throw new IllegalArgumentException("Percent splits expected");
            }
            sum += percentSplit.getPercent();
        }
        if (Math.abs(sum - 100.0) > 0.01) {
            throw new IllegalArgumentException("Percent split must sum to 100");
        }
    }

    @Override
    public void apply(double totalAmount, List<Split> splits) {
        for (Split split : splits) {
            PercentSplit percentSplit = (PercentSplit) split;
            split.setAmount((totalAmount * percentSplit.getPercent()) / 100.0);
        }
    }
}
