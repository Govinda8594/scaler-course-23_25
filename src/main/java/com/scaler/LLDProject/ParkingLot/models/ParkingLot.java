package com.scaler.LLDProject.ParkingLot.models;

import java.util.List;

public class ParkingLot {

    private Long id;
    private List<Floor> floors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;

    public ParkingLot(Long id, List<Floor> floors, List<Gate> gates, ParkingLotStatus parkingLotStatus) {
        this.id = id;
        this.floors = floors;
        this.gates = gates;
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}
