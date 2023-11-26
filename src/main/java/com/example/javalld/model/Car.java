package com.example.javalld.model;

public class Car implements Vehicle {
    @Override
    public int noOfWheels() {
        return 4;
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}
