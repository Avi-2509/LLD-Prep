package com.interview.practice.lld.paymentprocessor.gateway;

import com.interview.practice.lld.paymentprocessor.model.Payment;
import com.interview.practice.lld.paymentprocessor.model.PaymentResponse;

public class UpiPaymentGateway implements PaymentGateway {
    @Override
    public PaymentResponse authorize(Payment payment) {
        return new PaymentResponse(true, "UPI authorized");
    }

    @Override
    public PaymentResponse capture(Payment payment) {
        return new PaymentResponse(true, "UPI captured");
    }

    @Override
    public PaymentResponse refund(Payment payment) {
        return new PaymentResponse(true, "UPI refunded");
    }
}
