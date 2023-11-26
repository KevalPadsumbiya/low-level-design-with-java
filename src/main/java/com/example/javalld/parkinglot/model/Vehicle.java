package com.example.javalld.parkinglot.model;

public class Vehicle {
    private String numberPlate;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType, String numberPlate) {
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
    }

    public String getVehiclePlate() {
        return numberPlate;
    }
}
