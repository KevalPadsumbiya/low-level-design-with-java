package com.example.javalld.parkinglot.serviceclasses;

import com.example.javalld.parkinglot.model.Ticket;
import com.example.javalld.parkinglot.model.TicketStatus;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

@Slf4j
public class ExitGate {
    private String exitGateName;

    public ExitGate(String exitGateName) {
        this.exitGateName = exitGateName;
    }

    public double calculateTotalFee(Ticket ticket) {
        log.info("Vehicle: {} is exiting form exit gate: {}", ticket.getVehicle().getVehiclePlate(), this.exitGateName);
        double totalHours = Duration.between(ticket.getIssuedAt(), Instant.now()).toSeconds() / 3600.0;
        ticket.setTicketStatus(TicketStatus.PAID);
        return totalHours * ticket.getParkingSpot().getParkingSpotFeePerHour();
    }
}
