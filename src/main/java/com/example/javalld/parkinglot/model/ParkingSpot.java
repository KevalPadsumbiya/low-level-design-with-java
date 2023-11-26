package com.example.javalld.parkinglot.model;

public class ParkingSpot {
    private ParkingSpotType parkingSpotType;
    private double parkingSpotFeePerHour;
    private boolean isReserved;
    private int parkingSpotNo;
    private Vehicle vehicle;

    public ParkingSpot(ParkingSpotType parkingSpotType, double parkingSpotFeePerHour, int parkingSpotNo) {
        this.parkingSpotType = parkingSpotType;
        this.isReserved = false;
        this.parkingSpotFeePerHour = parkingSpotFeePerHour;
        this.vehicle = null;
        this.parkingSpotNo = parkingSpotNo;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public double getParkingSpotFeePerHour() {
        return parkingSpotFeePerHour;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public int getParkingSpotNo() {
        return parkingSpotNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isReserved = true;
    }

    public void unAssignSpot() {
        this.vehicle = null;
        this.isReserved = false;
    }
}
