package com.example.javalld.model;

public class MargheritaPizza implements Pizza {
    @Override
    public int getCost() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Margherita pizza";
    }
}
