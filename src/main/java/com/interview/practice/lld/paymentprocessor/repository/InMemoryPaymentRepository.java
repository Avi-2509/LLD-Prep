package com.interview.practice.lld.paymentprocessor.repository;

import com.interview.practice.lld.paymentprocessor.model.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryPaymentRepository implements PaymentRepository {
    private final Map<String, Payment> paymentsByIdempotencyKey = new HashMap<>();

    @Override
    public void save(Payment payment, String idempotencyKey) {
        paymentsByIdempotencyKey.put(idempotencyKey, payment);
    }

    @Override
    public Optional<Payment> findByIdempotencyKey(String idempotencyKey) {
        return Optional.ofNullable(paymentsByIdempotencyKey.get(idempotencyKey));
    }

    @Override
    public List<Payment> findAll() {
        return new ArrayList<>(paymentsByIdempotencyKey.values());
    }
}
