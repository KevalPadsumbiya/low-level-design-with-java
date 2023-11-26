package com.example.javalld.model;

public class Bike implements Vehicle {

    @Override
    public int noOfWheels() {
        return 2;
    }

    @Override
    public boolean hasEngine() {
        return true;
    }
}
