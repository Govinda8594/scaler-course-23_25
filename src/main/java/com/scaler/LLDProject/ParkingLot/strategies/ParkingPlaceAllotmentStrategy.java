package com.scaler.LLDProject.ParkingLot.strategies;


import com.scaler.LLDProject.ParkingLot.exceptions.ParkingLotFullException;
import com.scaler.LLDProject.ParkingLot.models.ParkingLot;
import com.scaler.LLDProject.ParkingLot.models.ParkingSpot;
import com.scaler.LLDProject.ParkingLot.models.VehicleType;

public interface ParkingPlaceAllotmentStrategy {

    ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingLotFullException;
}
