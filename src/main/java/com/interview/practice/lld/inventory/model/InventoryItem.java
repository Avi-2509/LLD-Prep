package com.interview.practice.lld.inventory.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class InventoryItem {
    private final String productId;
    private int availableQuantity;
    private int reservedQuantity;
    private final List<InventoryMovement> history = new ArrayList<>();

    public InventoryItem(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public int getReservedQuantity() {
        return reservedQuantity;
    }

    public void adjust(int delta, String reason, Instant at) {
        availableQuantity += delta;
        history.add(new InventoryMovement(productId, delta, reason, at));
    }

    public void reserve(int quantity) {
        availableQuantity -= quantity;
        reservedQuantity += quantity;
        history.add(new InventoryMovement(productId, -quantity, "reserve", Instant.now()));
    }
}
