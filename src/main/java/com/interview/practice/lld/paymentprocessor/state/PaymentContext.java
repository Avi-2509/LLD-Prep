package com.interview.practice.lld.paymentprocessor.state;

import com.interview.practice.lld.paymentprocessor.gateway.PaymentGateway;
import com.interview.practice.lld.paymentprocessor.model.Payment;

public class PaymentContext {
    private final Payment payment;
    private final PaymentGateway gateway;
    private PaymentState state;

    public PaymentContext(Payment payment, PaymentGateway gateway) {
        this.payment = payment;
        this.gateway = gateway;
        this.state = new CreatedState();
    }

    public void execute() {
        state.process(this);
    }

    public Payment getPayment() { return payment; }
    public PaymentGateway getGateway() { return gateway; }
    public void setState(PaymentState state) { this.state = state; }
}
