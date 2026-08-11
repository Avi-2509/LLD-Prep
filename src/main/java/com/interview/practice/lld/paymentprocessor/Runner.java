package com.interview.practice.lld.paymentprocessor;

import com.interview.practice.lld.paymentprocessor.gateway.PaymentGatewayFactory;
import com.interview.practice.lld.paymentprocessor.model.Payment;
import com.interview.practice.lld.paymentprocessor.model.PaymentMethodType;
import com.interview.practice.lld.paymentprocessor.model.PaymentRequest;
import com.interview.practice.lld.paymentprocessor.repository.InMemoryPaymentRepository;
import com.interview.practice.lld.paymentprocessor.service.PaymentService;

public class Runner {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(
                new InMemoryPaymentRepository(),
                new PaymentGatewayFactory()
        );

        PaymentRequest request = new PaymentRequest(
                "pay_1001",
                "idem_abc_123",
                "order_9001",
                "cust_501",
                2499.0,
                PaymentMethodType.CARD
        );

        System.out.println("Step 1: Creating payment");
        Payment payment = paymentService.process(request);
        System.out.println(payment.getPaymentId() + " | status = " + payment.getStatus());

        System.out.println("Step 2: Sending duplicate request with same idempotency key");
        Payment duplicate = paymentService.process(request);
        System.out.println(duplicate.getPaymentId() + " | status = " + duplicate.getStatus());

        System.out.println("Step 3: Running reconciliation");
        paymentService.reconcile();
        System.out.println(payment.getPaymentId() + " | final status = " + payment.getStatus());
    }
}
