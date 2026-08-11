package com.interview.practice.lld.splitwise;

import java.util.List;

public interface SplitStrategy {
    void validate(double totalAmount, List<Split> splits);
    void apply(double totalAmount, List<Split> splits);
}
