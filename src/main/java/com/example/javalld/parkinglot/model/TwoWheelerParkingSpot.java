package com.example.javalld.parkinglot.model;

public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(int parkingSpotNumber) {
        super(ParkingSpotType.TWO_WHEELER, 50.0, parkingSpotNumber);
    }
}
