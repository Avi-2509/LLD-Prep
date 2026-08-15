package com.interview.practice.lld.inventory.model;

import java.time.Instant;

public record InventoryMovement(String productId, int delta, String reason, Instant at) {}
