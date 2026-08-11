package com.interview.practice.lld.paymentprocessor.repository;

import com.interview.practice.lld.paymentprocessor.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    void save(Payment payment, String idempotencyKey);
    Optional<Payment> findByIdempotencyKey(String idempotencyKey);
    List<Payment> findAll();
}
