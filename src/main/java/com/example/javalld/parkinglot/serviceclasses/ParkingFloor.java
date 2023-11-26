package com.example.javalld.parkinglot.serviceclasses;

import com.example.javalld.parkinglot.exceptions.ParkingSpotNotAvailable;
import com.example.javalld.parkinglot.model.ParkingSpot;
import com.example.javalld.parkinglot.model.ParkingSpotType;
import com.example.javalld.parkinglot.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ParkingFloor {
    private Map<String, List<ParkingSpot>> availableParkingSpots;
    private Map<String, Map<Integer, ParkingSpot>> reservedParkingSpots;
    private String parkingFloorName;

    public ParkingFloor(String parkingFloorName) {
        this.parkingFloorName = parkingFloorName;
        this.availableParkingSpots = new HashMap<>();
        this.availableParkingSpots.put(ParkingSpotType.TWO_WHEELER.name(), new ArrayList<ParkingSpot>());
        this.availableParkingSpots.put(ParkingSpotType.HANDICAPPED.name(), new ArrayList<ParkingSpot>());
        this.availableParkingSpots.put(ParkingSpotType.COMPACT.name(), new ArrayList<ParkingSpot>());
        this.availableParkingSpots.put(ParkingSpotType.LARGE.name(), new ArrayList<ParkingSpot>());

        this.reservedParkingSpots = new HashMap<>();
        this.reservedParkingSpots.put(ParkingSpotType.TWO_WHEELER.name(), new HashMap<Integer, ParkingSpot>());
        this.reservedParkingSpots.put(ParkingSpotType.HANDICAPPED.name(), new HashMap<Integer, ParkingSpot>());
        this.reservedParkingSpots.put(ParkingSpotType.COMPACT.name(), new HashMap<Integer, ParkingSpot>());
        this.reservedParkingSpots.put(ParkingSpotType.LARGE.name(), new HashMap<Integer, ParkingSpot>());
    }

    public String getParkingFloorName() {
        return parkingFloorName;
    }

    public ParkingSpot assignParkingSpot(Vehicle vehicle, ParkingSpotType parkingSpotType) throws ParkingSpotNotAvailable {
        if (CollectionUtils.isEmpty(availableParkingSpots.get(parkingSpotType.name()))) {
            throw new ParkingSpotNotAvailable(String.format("Parking spot of type %s is not available!", parkingSpotType.name()));
        }

        ParkingSpot assignedParkingSpot = availableParkingSpots.get(parkingSpotType.name()).get(0);
        List<ParkingSpot> parkingSpots = availableParkingSpots.get(parkingSpotType.name());
        parkingSpots.remove(0);
        availableParkingSpots.put(parkingSpotType.name(), parkingSpots);

        assignedParkingSpot.assignVehicle(vehicle);
        reservedParkingSpots.get(parkingSpotType.name()).put(assignedParkingSpot.getParkingSpotNo(), assignedParkingSpot);

        log.info("Reserved the parking spot: {} on parking floor: {} for vehicle: {}",
                assignedParkingSpot.getParkingSpotNo(), parkingFloorName, vehicle.getVehiclePlate());

        return assignedParkingSpot;
    }

    public void unAssignParkingSpot(ParkingSpot parkingSpot) {
        log.info("Un-reserving the parking spot: {} on parking floor: {} for vehicle: {}",
                parkingFloorName, parkingSpot.getParkingSpotNo(), parkingSpot.getVehicle().getVehiclePlate());

        ParkingSpot assignedParkingSpot = reservedParkingSpots.get(parkingSpot.getParkingSpotType().name()).get(parkingSpot.getParkingSpotNo());
        availableParkingSpots.get(parkingSpot.getParkingSpotType().name()).add(parkingSpot);

        assignedParkingSpot.unAssignSpot();
        reservedParkingSpots.get(parkingSpot.getParkingSpotType().name()).remove(parkingSpot.getParkingSpotNo());
    }

    public boolean isParkingSpotAvailable(ParkingSpotType parkingSpotType) {
        return !CollectionUtils.isEmpty(availableParkingSpots.get(parkingSpotType.name()));
    }

    public boolean isParkingSpotAvailable() {
        for (Map.Entry<String, List<ParkingSpot>> parkingSpot : availableParkingSpots.entrySet()) {
            if (parkingSpot.getValue().size() > 0) {
                return true;
            }
        }

        return false;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        List<ParkingSpot> parkingSpots = availableParkingSpots.get(parkingSpot.getParkingSpotType().name());
        parkingSpots.add(parkingSpot);
        availableParkingSpots.put(parkingSpot.getParkingSpotType().name(), parkingSpots);
    }
}
