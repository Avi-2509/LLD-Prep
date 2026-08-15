package com.interview.practice.lld.inventory.model;

public record InventoryView(
        String warehouseId,
        String warehouseName,
        String productId,
        String productName,
        int availableQuantity,
        int reservedQuantity
) {
    @Override
    public String toString() {
        return "InventoryView{" +
                "warehouseId='" + warehouseId + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", availableQuantity=" + availableQuantity +
                ", reservedQuantity=" + reservedQuantity +
                '}';
    }
}
