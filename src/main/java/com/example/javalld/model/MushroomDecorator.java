package com.example.javalld.model;

public class MushroomDecorator extends ToppingsDecorator {
    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getToppingCost() {
        return 25;
    }

    @Override
    public String getToppingDescription() {
        return "Mushrooms";
    }
}
