package com.example.javalld.parkinglot.model;

import com.example.javalld.parkinglot.serviceclasses.EntryGate;
import com.example.javalld.parkinglot.serviceclasses.ParkingFloor;

import java.time.Instant;

public class Ticket {
    private Instant issuedAt;
    private TicketStatus ticketStatus;
    private Vehicle vehicle;
    private ParkingFloor parkingFloor;
    private ParkingSpot parkingSpot;
    private EntryGate entryGate;

    public Ticket(ParkingFloor parkingFloor, EntryGate entryGate, Vehicle vehicle, Instant issuedAt, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.issuedAt = issuedAt;
        this.ticketStatus = TicketStatus.ACTIVE;
        this.parkingFloor = parkingFloor;
        this.entryGate = entryGate;
        this.parkingSpot = parkingSpot;
    }

    public Instant getIssuedAt() {
        return issuedAt;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public EntryGate getEntryGate() {
        return entryGate;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
