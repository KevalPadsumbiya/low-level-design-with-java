package com.example.javalld.model;

public class FarmHousePizza implements Pizza {
    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Farm House Pizza";
    }
}
