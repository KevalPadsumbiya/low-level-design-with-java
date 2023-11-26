package com.example.javalld.parkinglot.serviceclasses;

import com.example.javalld.parkinglot.model.ParkingSpot;
import com.example.javalld.parkinglot.model.Ticket;
import com.example.javalld.parkinglot.model.Vehicle;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
public class EntryGate {
    private String entryGateName;

    public EntryGate(String entryGateName) {
        this.entryGateName = entryGateName;
    }

    public Ticket getTicket(ParkingFloor parkingFloor, Vehicle vehicle, ParkingSpot parkingSpot) {
        log.info("Creating ticket for parking spot: {} from entry gate: {} for vehicle: {} in parking floor: {}", parkingSpot.getParkingSpotNo(), this.entryGateName, vehicle.getVehiclePlate(), parkingFloor.getParkingFloorName());
        return new Ticket(parkingFloor, this, vehicle, Instant.now(), parkingSpot);
    }
}
