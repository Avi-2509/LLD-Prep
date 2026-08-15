package com.interview.practice.lld.inventory.service;

import com.interview.practice.lld.inventory.model.InventoryItem;
import com.interview.practice.lld.inventory.model.InventoryView;
import com.interview.practice.lld.inventory.model.LowStockListener;
import com.interview.practice.lld.inventory.model.Product;
import com.interview.practice.lld.inventory.model.TransferReceipt;
import com.interview.practice.lld.inventory.model.TransferStatus;
import com.interview.practice.lld.inventory.model.Warehouse;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryService {
    private final Map<String, Warehouse> warehouses = new ConcurrentHashMap<>();
    private final Map<String, Product> products = new ConcurrentHashMap<>();
    private final List<LowStockListener> lowStockListeners = new CopyOnWriteArrayList<>();
    private final int lowStockThreshold = 10;

    public void addLowStockListener(LowStockListener listener) {
        lowStockListeners.add(listener);
    }

    public void createWarehouse(String id, String name) {
        warehouses.putIfAbsent(id, new Warehouse(id, name));
    }

    public void addProduct(Product product) {
        products.putIfAbsent(product.getId(), product);
    }

    public void receiveStock(String warehouseId, String productId, int quantity) {
        adjustStock(warehouseId, productId, quantity, "stock received", Instant.now());
    }

    public void reserveStock(String warehouseId, String productId, int quantity) {
        Warehouse warehouse = getWarehouseOrThrow(warehouseId);
        warehouse.lock();
        try {
            InventoryItem item = warehouse.getOrCreateItem(productId);
            if (item.getAvailableQuantity() < quantity) {
                throw new IllegalStateException("Not enough stock for product " + productId);
            }
            item.reserve(quantity);
            checkLowStock(warehouseId, productId, item.getAvailableQuantity());
        } finally {
            warehouse.unlock();
        }
    }

    public void adjustStock(String warehouseId, String productId, int delta, String reason, Instant at) {
        Warehouse warehouse = getWarehouseOrThrow(warehouseId);
        warehouse.lock();
        try {
            InventoryItem item = warehouse.getOrCreateItem(productId);
            int nextQuantity = item.getAvailableQuantity() + delta;
            if (nextQuantity < 0) {
                throw new IllegalStateException("Inventory cannot go negative for product " + productId);
            }
            item.adjust(delta, reason, at);
            checkLowStock(warehouseId, productId, item.getAvailableQuantity());
        } finally {
            warehouse.unlock();
        }
    }

    public List<InventoryView> getInventorySnapshot(String warehouseId) {
        Warehouse warehouse = getWarehouseOrThrow(warehouseId);
        warehouse.lock();
        try {
            List<InventoryView> views = new ArrayList<>();
            for (InventoryItem item : warehouse.getItems()) {
                Product product = products.get(item.getProductId());
                views.add(new InventoryView(
                        warehouse.getId(),
                        warehouse.getName(),
                        item.getProductId(),
                        product != null ? product.getName() : "unknown",
                        item.getAvailableQuantity(),
                        item.getReservedQuantity()
                ));
            }
            views.sort(Comparator.comparing(InventoryView::productId));
            return views;
        } finally {
            warehouse.unlock();
        }
    }

    public List<TransferReceipt> transferStock(String fromWarehouseId, String toWarehouseId, String productId, int quantity) {
        Warehouse first = getWarehouseOrThrow(fromWarehouseId);
        Warehouse second = getWarehouseOrThrow(toWarehouseId);

        Warehouse left = first.getId().compareTo(second.getId()) <= 0 ? first : second;
        Warehouse right = left == first ? second : first;

        left.lock();
        right.lock();
        try {
            InventoryItem source = first.getOrCreateItem(productId);
            if (source.getAvailableQuantity() < quantity) {
                throw new IllegalStateException("Not enough stock to transfer");
            }
            source.adjust(-quantity, "transfer out", Instant.now());

            InventoryItem destination = second.getOrCreateItem(productId);
            destination.adjust(quantity, "transfer in", Instant.now());

            checkLowStock(first.getId(), productId, source.getAvailableQuantity());
            checkLowStock(second.getId(), productId, destination.getAvailableQuantity());

            return List.of(new TransferReceipt(fromWarehouseId, toWarehouseId, productId, quantity, TransferStatus.COMPLETED));
        } finally {
            right.unlock();
            left.unlock();
        }
    }

    private Warehouse getWarehouseOrThrow(String warehouseId) {
        Warehouse warehouse = warehouses.get(warehouseId);
        if (warehouse == null) {
            throw new IllegalArgumentException("Warehouse not found: " + warehouseId);
        }
        return warehouse;
    }

    private void checkLowStock(String warehouseId, String productId, int availableQuantity) {
        if (availableQuantity <= lowStockThreshold) {
            for (LowStockListener listener : lowStockListeners) {
                listener.onLowStock(warehouseId, productId, availableQuantity);
            }
        }
    }
}
