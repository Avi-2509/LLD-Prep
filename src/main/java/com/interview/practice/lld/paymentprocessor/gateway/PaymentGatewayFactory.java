package com.interview.practice.lld.paymentprocessor.gateway;

import com.interview.practice.lld.paymentprocessor.model.PaymentMethodType;

public class PaymentGatewayFactory {
    public PaymentGateway getGateway(PaymentMethodType type) {
        return switch (type) {
            case CARD -> new CardPaymentGateway();
            case UPI -> new UpiPaymentGateway();
            case WALLET -> new UpiPaymentGateway();
            case NET_BANKING -> new CardPaymentGateway();
        };
    }
}
