package com.interview.practice.lld.paymentprocessor.state;

import com.interview.practice.lld.paymentprocessor.model.PaymentResponse;
import com.interview.practice.lld.paymentprocessor.model.PaymentStatus;

public class CreatedState implements PaymentState {
    @Override
    public void process(PaymentContext context) {
        PaymentResponse response = context.getGateway().authorize(context.getPayment());
        if (response.isSuccess()) {
            context.getPayment().setStatus(PaymentStatus.AUTHORIZED);
            context.setState(new AuthorizedState());
        } else {
            context.getPayment().setStatus(PaymentStatus.FAILED);
        }
    }
}
