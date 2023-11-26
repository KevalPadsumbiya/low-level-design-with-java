package com.example.javalld.parkinglot.serviceclasses;

import com.example.javalld.parkinglot.model.*;

public class ParkingSpotFactory {
    public static ParkingSpot getParkingSpot(ParkingSpotType parkingSpotType, int parkingSpotNo) {
        switch (parkingSpotType) {
            case HANDICAPPED:
                return new HandicappedParkingSpot(parkingSpotNo);
            case TWO_WHEELER:
                return new TwoWheelerParkingSpot(parkingSpotNo);
            case COMPACT:
                return new CompactParkingSpot(parkingSpotNo);
            case LARGE:
                return new LargeParkingSpot(parkingSpotNo);
        }

        return null;
    }
}
