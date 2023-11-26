package com.example.javalld.parkinglot.model;

public class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot(int parkingSpotNumber) {
        super(ParkingSpotType.LARGE, 100.0, parkingSpotNumber);
    }
}
