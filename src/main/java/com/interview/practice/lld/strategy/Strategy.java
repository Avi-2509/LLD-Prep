package com.interview.practice.lld.strategy;

public class Strategy {
}

interface RateLimitStrategy {
    boolean allow(String clientId);
}

class TokenBucketStrategy implements RateLimitStrategy {
    @Override
    public boolean allow(String clientId) {
        return true;
    }
}

class SlidingWindowStrategy implements RateLimitStrategy {
    @Override
    public boolean allow(String clientId) {
        return true;
    }
}

class RateLimiter {
    private final RateLimitStrategy strategy;

    RateLimiter(RateLimitStrategy strategy) {
        this.strategy = strategy;
    }

    boolean allow(String clientId) {
        return strategy.allow(clientId);
    }
}