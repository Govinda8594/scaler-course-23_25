package com.scaler.LLDProject.ParkingLot.respository;


import com.scaler.LLDProject.ParkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }

    public void setVehicleMap(Map<String, Vehicle> vehicleMap) {
        this.vehicleMap = vehicleMap;
    }

    public Vehicle getVehicleByNumber(String number) {
        if (vehicleMap.containsKey(number))
            return vehicleMap.get(number);
        return null;
    }

    public void save(Vehicle newvehicle) {
        vehicleMap.put(newvehicle.getNumber(), newvehicle);
    }
}
