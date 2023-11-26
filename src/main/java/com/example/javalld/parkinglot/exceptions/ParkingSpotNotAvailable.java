package com.example.javalld.parkinglot.exceptions;

public class ParkingSpotNotAvailable extends Exception {
    public ParkingSpotNotAvailable(String error) {
        super(error);
    }
}
