package com.interview.practice.lld.inventory.model;

@FunctionalInterface
public interface LowStockListener {
    void onLowStock(String warehouseId, String productId, int availableQuantity);
}
