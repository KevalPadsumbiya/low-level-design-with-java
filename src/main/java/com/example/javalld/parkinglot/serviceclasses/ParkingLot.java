package com.example.javalld.parkinglot.serviceclasses;

import com.example.javalld.parkinglot.exceptions.InvalidPaymentType;
import com.example.javalld.parkinglot.exceptions.ParkingLotFullException;
import com.example.javalld.parkinglot.exceptions.ParkingSpotNotAvailable;
import com.example.javalld.parkinglot.model.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloorList;
    private String parkingLotName;

    private static ParkingLot parkingLot = null;

    private ParkingLot(String parkingLotName) {
        this.parkingLotName = parkingLotName;
        this.parkingFloorList = new ArrayList<>();
    }

    public static ParkingLot getInstance(String parkingLotName) {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(parkingLotName);
        }
        return parkingLot;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloorList.add(parkingFloor);
    }

    public synchronized Ticket getNewParkingTicket(EntryGate entryGate, Vehicle vehicle, ParkingSpotType parkingSpotType) throws ParkingLotFullException, ParkingSpotNotAvailable {
        if (this.isParkingLotFull(parkingSpotType)) {
            throw new ParkingLotFullException();
        }

        return assignParkingSpot(entryGate, vehicle, parkingSpotType);
    }

    public Ticket assignParkingSpot(EntryGate entryGate, Vehicle vehicle, ParkingSpotType parkingSpotType) throws ParkingSpotNotAvailable {
        for (ParkingFloor parkingFloor : this.parkingFloorList) {
            if (parkingFloor.isParkingSpotAvailable(parkingSpotType)) {
                ParkingSpot parkingSpot = parkingFloor.assignParkingSpot(vehicle, parkingSpotType);
                return entryGate.getTicket(parkingFloor, vehicle, parkingSpot);
            }
        }

        throw new ParkingSpotNotAvailable(String.format("Parking spot of type %s is not available!", parkingSpotType.name()));
    }

    public void unAssignParkingSpot(Ticket ticket, PaymentType paymentType, ExitGate exitGate) throws InvalidPaymentType {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.collectPayment(ticket, paymentType, exitGate.calculateTotalFee(ticket));
        ticket.getParkingFloor().unAssignParkingSpot(ticket.getParkingSpot());
    }

    public boolean isParkingLotFull(ParkingSpotType parkingSpotType) {
        for (ParkingFloor parkingFloor : this.parkingFloorList) {
            if (parkingFloor.isParkingSpotAvailable(parkingSpotType))
                return true;
        }
        return false;
    }

    public boolean isParkingLotFull() {
        for (ParkingFloor parkingFloor : this.parkingFloorList) {
            if (parkingFloor.isParkingSpotAvailable()) {
                return false;
            }
        }

        return true;
    }
}
