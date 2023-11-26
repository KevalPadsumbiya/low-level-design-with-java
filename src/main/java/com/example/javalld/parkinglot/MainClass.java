package com.example.javalld.parkinglot;

import com.example.javalld.parkinglot.exceptions.InvalidPaymentType;
import com.example.javalld.parkinglot.exceptions.ParkingSpotNotAvailable;
import com.example.javalld.parkinglot.model.*;
import com.example.javalld.parkinglot.serviceclasses.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainClass {
    public static void main(String[] args) throws ParkingSpotNotAvailable, InvalidPaymentType, InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance("Star Parking Lot");

        parkingLot.addParkingFloor(getParkingFloor("Floor 1"));
        parkingLot.addParkingFloor(getParkingFloor("Floor 2"));

        Ticket ticket1 = parkingLot.assignParkingSpot(new EntryGate("Entry gate 1"), new Vehicle(VehicleType.CAR, "AB-01-CD-1234"), ParkingSpotType.COMPACT);
        Ticket ticket2 = parkingLot.assignParkingSpot(new EntryGate("Entry gate 2"), new Vehicle(VehicleType.MOTORBIKE, "AB-02-CD-1234"), ParkingSpotType.TWO_WHEELER);
        Ticket ticket3 = parkingLot.assignParkingSpot(new EntryGate("Entry gate 3"), new Vehicle(VehicleType.TRUCK, "AB-03-CD-1234"), ParkingSpotType.LARGE);
        Ticket ticket4 = parkingLot.assignParkingSpot(new EntryGate("Entry gate 4"), new Vehicle(VehicleType.MOTORBIKE, "AB-04-CD-1234"), ParkingSpotType.HANDICAPPED);

        log.info("Is parking lot full: {}", parkingLot.isParkingLotFull());

        Ticket ticket5 = parkingLot.assignParkingSpot(new EntryGate("Entry gate 1"), new Vehicle(VehicleType.CAR, "AB-05-CD-1234"), ParkingSpotType.COMPACT);
        Ticket ticket6 = parkingLot.assignParkingSpot(new EntryGate("Entry gate 2"), new Vehicle(VehicleType.MOTORBIKE, "AB-06-CD-1234"), ParkingSpotType.TWO_WHEELER);
        Ticket ticket7 = parkingLot.assignParkingSpot(new EntryGate("Entry gate 3"), new Vehicle(VehicleType.TRUCK, "AB-07-CD-1234"), ParkingSpotType.LARGE);
        Ticket ticket8 = parkingLot.assignParkingSpot(new EntryGate("Entry gate 4"), new Vehicle(VehicleType.MOTORBIKE, "AB-08-CD-1234"), ParkingSpotType.HANDICAPPED);

        log.info("Is parking lot full: {}", parkingLot.isParkingLotFull());

        Thread.sleep(10000);

        PaymentProcessor paymentProcessor = new PaymentProcessor();

        ExitGate exitGate1 = new ExitGate("Exit Gate 1");
        paymentProcessor.collectPayment(ticket1, PaymentType.UPI, exitGate1.calculateTotalFee(ticket1));
        paymentProcessor.collectPayment(ticket2, PaymentType.CREDIT_CARD, exitGate1.calculateTotalFee(ticket2));
        paymentProcessor.collectPayment(ticket3, PaymentType.UPI, exitGate1.calculateTotalFee(ticket3));
        paymentProcessor.collectPayment(ticket4, PaymentType.CREDIT_CARD, exitGate1.calculateTotalFee(ticket4));
        paymentProcessor.collectPayment(ticket5, PaymentType.UPI, exitGate1.calculateTotalFee(ticket5));

        ticket1.getParkingFloor().unAssignParkingSpot(ticket1.getParkingSpot());
        ticket2.getParkingFloor().unAssignParkingSpot(ticket2.getParkingSpot());
        ticket3.getParkingFloor().unAssignParkingSpot(ticket3.getParkingSpot());
        ticket4.getParkingFloor().unAssignParkingSpot(ticket4.getParkingSpot());
        ticket5.getParkingFloor().unAssignParkingSpot(ticket5.getParkingSpot());

        ExitGate exitGate2 = new ExitGate("Exit Gate 2");
        paymentProcessor.collectPayment(ticket6, PaymentType.CREDIT_CARD, exitGate2.calculateTotalFee(ticket6));
        paymentProcessor.collectPayment(ticket7, PaymentType.UPI, exitGate2.calculateTotalFee(ticket7));
        paymentProcessor.collectPayment(ticket8, PaymentType.CREDIT_CARD, exitGate2.calculateTotalFee(ticket8));

        ticket6.getParkingFloor().unAssignParkingSpot(ticket6.getParkingSpot());
        ticket7.getParkingFloor().unAssignParkingSpot(ticket7.getParkingSpot());
        ticket8.getParkingFloor().unAssignParkingSpot(ticket8.getParkingSpot());
    }

    public static ParkingFloor getParkingFloor(String parkingFloorName) {
        ParkingFloor parkingFloor = new ParkingFloor(parkingFloorName);

        parkingFloor.addParkingSpot(ParkingSpotFactory.getParkingSpot(ParkingSpotType.HANDICAPPED, 1));
        parkingFloor.addParkingSpot(ParkingSpotFactory.getParkingSpot(ParkingSpotType.TWO_WHEELER, 2));
        parkingFloor.addParkingSpot(ParkingSpotFactory.getParkingSpot(ParkingSpotType.COMPACT, 3));
        parkingFloor.addParkingSpot(ParkingSpotFactory.getParkingSpot(ParkingSpotType.LARGE, 4));

        return parkingFloor;
    }
}
