package com.interview.practice.lld.paymentprocessor.gateway;

import com.interview.practice.lld.paymentprocessor.model.Payment;
import com.interview.practice.lld.paymentprocessor.model.PaymentResponse;

public class CardPaymentGateway implements PaymentGateway {
    @Override
    public PaymentResponse authorize(Payment payment) {
        return new PaymentResponse(true, "Card authorized");
    }

    @Override
    public PaymentResponse capture(Payment payment) {
        return new PaymentResponse(true, "Card captured");
    }

    @Override
    public PaymentResponse refund(Payment payment) {
        return new PaymentResponse(true, "Card refunded");
    }
}
