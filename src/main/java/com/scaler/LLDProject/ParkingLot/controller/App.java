package com.scaler.LLDProject.ParkingLot.controller;


import com.scaler.LLDProject.ParkingLot.dtos.IssueTicketRequest;
import com.scaler.LLDProject.ParkingLot.dtos.IssueTicketResponse;
import com.scaler.LLDProject.ParkingLot.models.*;
import com.scaler.LLDProject.ParkingLot.respository.GateRepository;
import com.scaler.LLDProject.ParkingLot.respository.ParkingLotRespository;
import com.scaler.LLDProject.ParkingLot.respository.Ticketrepository;
import com.scaler.LLDProject.ParkingLot.respository.VehicleRepository;
import com.scaler.LLDProject.ParkingLot.services.TicketService;
import com.scaler.LLDProject.ParkingLot.services.impl.TicketServcieImpl;
import com.scaler.LLDProject.ParkingLot.strategies.SimpleParkingSpotAllotmentStrategy;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Gate gate = new Gate(1l, GateType.ENTRY, GateStatus.WORKING);
        Floor floor = new Floor(1);
        for (int i = 0; i < 10; i++) {
            floor.getParkingSpots().add(new ParkingSpot(1, VehicleType.FOUR_WHEELER, ParkingSpotStatus.FILLED, floor));
        }
        ArrayList<Floor> floors = new ArrayList<Floor>();
        floors.add(floor);
        ArrayList<Gate> gates = new ArrayList<Gate>();
        gates.add(gate);
        ParkingLot parkingLot = new ParkingLot(1l, floors, gates, ParkingLotStatus.ACTIVE);


        GateRepository gateRepository = new GateRepository();
        gateRepository.getGates().put(1l, gate);
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRespository parkingLotRespository = new ParkingLotRespository();

        parkingLotRespository.getParkingLotMap().put(1l, parkingLot);
        Ticketrepository ticketRepository = new Ticketrepository();
        TicketService ticketService = new TicketServcieImpl(gateRepository, vehicleRepository, parkingLotRespository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);
        IssueTicketRequest issueTicketRequest = new IssueTicketRequest(VehicleType.FOUR_WHEELER, "KA-01", "Govinda", 1l, 1l, new SimpleParkingSpotAllotmentStrategy());

        IssueTicketResponse issueTicketResponse = ticketController.issueTicket(issueTicketRequest);
        System.out.println(issueTicketResponse);
    }
}
