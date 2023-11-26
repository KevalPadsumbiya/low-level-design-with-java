package com.example.javalld.parkinglot.model;

public class HandicappedParkingSpot extends ParkingSpot {
    public HandicappedParkingSpot(int parkingSpotNumber) {
        super(ParkingSpotType.HANDICAPPED, 25.0, parkingSpotNumber);
    }
}
