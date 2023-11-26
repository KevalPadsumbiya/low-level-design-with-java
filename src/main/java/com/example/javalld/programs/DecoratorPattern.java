package com.example.javalld.programs;

import com.example.javalld.model.CheeseDecorator;
import com.example.javalld.model.MargheritaPizza;
import com.example.javalld.model.MushroomDecorator;
import com.example.javalld.model.Pizza;

public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza = new MargheritaPizza();
        System.out.println("Pizza: " + pizza.getDescription() + ", Cost: " + pizza.getCost());

        pizza = new CheeseDecorator(pizza);
        System.out.println("Pizza: " + pizza.getDescription() + ", Cost: " + pizza.getCost());

        pizza = new MushroomDecorator(pizza);
        System.out.println("Pizza: " + pizza.getDescription() + ", Cost: " + pizza.getCost());
    }
}
