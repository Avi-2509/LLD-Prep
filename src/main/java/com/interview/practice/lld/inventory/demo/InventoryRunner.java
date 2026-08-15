package com.interview.practice.lld.inventory.demo;

import com.interview.practice.lld.inventory.model.Product;
import com.interview.practice.lld.inventory.model.TransferReceipt;
import com.interview.practice.lld.inventory.service.InventoryService;

import java.time.Instant;
import java.util.List;

public class InventoryRunner {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        inventoryService.addLowStockListener((warehouseId, productId, availableQuantity) ->
                System.out.println("LOW STOCK ALERT -> warehouse=" + warehouseId
                        + ", product=" + productId
                        + ", available=" + availableQuantity));

        inventoryService.createWarehouse("WH-1", "Bengaluru");
        inventoryService.createWarehouse("WH-2", "Delhi");

        inventoryService.addProduct(new Product("P-100", "Keyboard"));
        inventoryService.addProduct(new Product("P-200", "Mouse"));

        inventoryService.receiveStock("WH-1", "P-100", 50);
        inventoryService.receiveStock("WH-1", "P-200", 20);
        inventoryService.receiveStock("WH-2", "P-100", 30);

        inventoryService.reserveStock("WH-1", "P-100", 45);
        inventoryService.reserveStock("WH-2", "P-100", 10);

        System.out.println("Availability snapshot:");
        inventoryService.getInventorySnapshot("WH-1").forEach(System.out::println);

        List<TransferReceipt> receipts = inventoryService.transferStock("WH-1", "WH-2", "P-200", 5);
        receipts.forEach(System.out::println);

        inventoryService.adjustStock("WH-2", "P-100", -3, "manual correction", Instant.now());
        System.out.println("Final snapshot WH-2:");
        inventoryService.getInventorySnapshot("WH-2").forEach(System.out::println);
    }
}
