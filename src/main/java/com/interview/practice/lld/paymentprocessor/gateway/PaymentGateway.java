package com.interview.practice.lld.paymentprocessor.gateway;

import com.interview.practice.lld.paymentprocessor.model.Payment;
import com.interview.practice.lld.paymentprocessor.model.PaymentResponse;

public interface PaymentGateway {
    PaymentResponse authorize(Payment payment);
    PaymentResponse capture(Payment payment);
    PaymentResponse refund(Payment payment);
}
