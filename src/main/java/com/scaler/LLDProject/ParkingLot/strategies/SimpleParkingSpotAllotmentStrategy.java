package com.scaler.LLDProject.ParkingLot.strategies;


import com.scaler.LLDProject.ParkingLot.exceptions.ParkingLotFullException;
import com.scaler.LLDProject.ParkingLot.models.*;

public class SimpleParkingSpotAllotmentStrategy implements ParkingPlaceAllotmentStrategy {

    @Override
    public ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingLotFullException {
        for (Floor floor : parkingLot.getFloors()) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.getStatus().equals(ParkingSpotStatus.AVAILABLE)) {
                    if (spot.getVehicleType().equals(vehicleType)) {
                        return spot;
                    }
                }
            }
        }
        throw new ParkingLotFullException();
    }
}
