package com.example.javalld.model;

public class CheeseDecorator extends ToppingsDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getToppingCost() {
        return 10;
    }

    @Override
    public String getToppingDescription() {
        return "Cheese";
    }
}
