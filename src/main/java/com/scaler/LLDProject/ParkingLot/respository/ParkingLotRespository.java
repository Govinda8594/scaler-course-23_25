package com.scaler.LLDProject.ParkingLot.respository;


import com.scaler.LLDProject.ParkingLot.exceptions.ParkingLotException;
import com.scaler.LLDProject.ParkingLot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRespository {
    private Map<Long, ParkingLot> parkingLotMap = new HashMap<>();

    public Map<Long, ParkingLot> getParkingLotMap() {
        return parkingLotMap;
    }

    public void setParkingLotMap(Map<Long, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
    }

    public ParkingLot getparkingLotId(Long id) throws ParkingLotException {
        if (parkingLotMap.containsKey(id))
            return parkingLotMap.get(id);
        throw new ParkingLotException();
    }
}
