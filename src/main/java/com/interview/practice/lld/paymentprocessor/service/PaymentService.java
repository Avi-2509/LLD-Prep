package com.interview.practice.lld.paymentprocessor.service;

import com.interview.practice.lld.paymentprocessor.gateway.PaymentGateway;
import com.interview.practice.lld.paymentprocessor.gateway.PaymentGatewayFactory;
import com.interview.practice.lld.paymentprocessor.model.Payment;
import com.interview.practice.lld.paymentprocessor.model.PaymentRequest;
import com.interview.practice.lld.paymentprocessor.model.PaymentStatus;
import com.interview.practice.lld.paymentprocessor.repository.PaymentRepository;
import com.interview.practice.lld.paymentprocessor.state.PaymentContext;

public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentGatewayFactory gatewayFactory;

    public PaymentService(PaymentRepository repository, PaymentGatewayFactory gatewayFactory) {
        this.repository = repository;
        this.gatewayFactory = gatewayFactory;
    }

    public Payment process(PaymentRequest request) {
        return repository.findByIdempotencyKey(request.getIdempotencyKey())
                .orElseGet(() -> {
                    Payment payment = new Payment(
                            request.getPaymentId(),
                            request.getOrderId(),
                            request.getCustomerId(),
                            request.getAmount(),
                            request.getMethodType()
                    );
                    PaymentGateway gateway = gatewayFactory.getGateway(request.getMethodType());
                    PaymentContext context = new PaymentContext(payment, gateway);
                    context.execute();
                    repository.save(payment, request.getIdempotencyKey());
                    return payment;
                });
    }

    public void reconcile() {
        for (Payment payment : repository.findAll()) {
            if (payment.getStatus() == PaymentStatus.AUTHORIZED) {
                PaymentGateway gateway = gatewayFactory.getGateway(payment.getMethodType());
                PaymentContext context = new PaymentContext(payment, gateway);
                context.execute();
            }
        }
    }
}
