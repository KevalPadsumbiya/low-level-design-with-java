package com.example.javalld.parkinglot.model;

public class CompactParkingSpot extends ParkingSpot {
    public CompactParkingSpot(int parkingSpotNumber) {
        super(ParkingSpotType.COMPACT, 70.0, parkingSpotNumber);
    }
}
