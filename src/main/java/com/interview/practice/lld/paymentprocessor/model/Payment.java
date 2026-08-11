package com.interview.practice.lld.paymentprocessor.model;

public class Payment {
    private final String paymentId;
    private final String orderId;
    private final String customerId;
    private final double amount;
    private final PaymentMethodType methodType;
    private PaymentStatus status;

    public Payment(String paymentId, String orderId, String customerId, double amount, PaymentMethodType methodType) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
        this.methodType = methodType;
        this.status = PaymentStatus.CREATED;
    }

    public String getPaymentId() { return paymentId; }
    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public double getAmount() { return amount; }
    public PaymentMethodType getMethodType() { return methodType; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
}
