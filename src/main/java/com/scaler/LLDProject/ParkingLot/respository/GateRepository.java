package com.scaler.LLDProject.ParkingLot.respository;


import com.scaler.LLDProject.ParkingLot.exceptions.GateNotFoundException;
import com.scaler.LLDProject.ParkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {

    private Map<Long, Gate> gates = new HashMap<Long, Gate>();
    ;

    public Map<Long, Gate> getGates() {
        return gates;
    }

    public void setGates(Map<Long, Gate> gates) {
        this.gates = gates;
    }

    public Gate findGateById(Long id) throws GateNotFoundException {
        if (gates.containsKey(id))
            return gates.get(id);
        throw new GateNotFoundException();
    }
}
