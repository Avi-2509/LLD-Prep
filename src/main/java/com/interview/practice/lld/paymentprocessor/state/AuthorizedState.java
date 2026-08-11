package com.interview.practice.lld.paymentprocessor.state;

import com.interview.practice.lld.paymentprocessor.model.PaymentResponse;
import com.interview.practice.lld.paymentprocessor.model.PaymentStatus;

public class AuthorizedState implements PaymentState {
    @Override
    public void process(PaymentContext context) {
        PaymentResponse response = context.getGateway().capture(context.getPayment());
        if (response.isSuccess()) {
            context.getPayment().setStatus(PaymentStatus.CAPTURED);
            context.setState(new CapturedState());
        } else {
            context.getPayment().setStatus(PaymentStatus.FAILED);
        }
    }
}
