package com.interview.practice.lld.inventory.model;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {
    private final String id;
    private final String name;
    private final Map<String, InventoryItem> items = new ConcurrentHashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public Warehouse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public InventoryItem getOrCreateItem(String productId) {
        return items.computeIfAbsent(productId, InventoryItem::new);
    }

    public Collection<InventoryItem> getItems() {
        return items.values();
    }
}
