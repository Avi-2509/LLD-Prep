package com.interview.practice.lld.decorator;

public class Runner {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " -> " + coffee.getCost());

        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println(milkCoffee.getDescription() + " -> " + milkCoffee.getCost());

        Coffee sweetCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sweetCoffee.getDescription() + " -> " + sweetCoffee.getCost());

        Coffee premiumCoffee = new ChocolateDecorator(sweetCoffee);
        System.out.println(premiumCoffee.getDescription() + " -> " + premiumCoffee.getCost());
    }
}
