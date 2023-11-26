package com.example.javalld.model;

import java.util.ArrayList;
import java.util.List;

public abstract class ToppingsDecorator implements Pizza {
    public Pizza pizza;

    public ToppingsDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + getToppingCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", " + getToppingDescription();
    }

    public abstract int getToppingCost();

    public abstract String getToppingDescription();
}
