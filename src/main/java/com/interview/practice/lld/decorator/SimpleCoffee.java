package com.interview.practice.lld.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    @Override
    public double getCost() {
        return 100.0;
    }
}
