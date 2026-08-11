package com.interview.practice.lld.paymentprocessor.state;

public interface PaymentState {
    void process(PaymentContext context);
}
