package com.interview.practice.lld.inventory.model;

public record TransferReceipt(
        String fromWarehouseId,
        String toWarehouseId,
        String productId,
        int quantity,
        TransferStatus status
) {}
