package com.interview.practice.lld.paymentprocessor.model;

public class PaymentRequest {
    private final String paymentId;
    private final String idempotencyKey;
    private final String orderId;
    private final String customerId;
    private final double amount;
    private final PaymentMethodType methodType;

    public PaymentRequest(String paymentId, String idempotencyKey, String orderId, String customerId, double amount, PaymentMethodType methodType) {
        this.paymentId = paymentId;
        this.idempotencyKey = idempotencyKey;
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
        this.methodType = methodType;
    }

    public String getPaymentId() { return paymentId; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public double getAmount() { return amount; }
    public PaymentMethodType getMethodType() { return methodType; }
}
