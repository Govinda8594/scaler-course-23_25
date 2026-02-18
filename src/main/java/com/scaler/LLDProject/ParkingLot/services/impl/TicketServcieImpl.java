package com.scaler.LLDProject.ParkingLot.services.impl;


import com.scaler.LLDProject.ParkingLot.dtos.IssueTicketRequest;
import com.scaler.LLDProject.ParkingLot.exceptions.GateNotFoundException;
import com.scaler.LLDProject.ParkingLot.exceptions.ParkingLotException;
import com.scaler.LLDProject.ParkingLot.exceptions.ParkingLotFullException;
import com.scaler.LLDProject.ParkingLot.models.*;
import com.scaler.LLDProject.ParkingLot.respository.GateRepository;
import com.scaler.LLDProject.ParkingLot.respository.ParkingLotRespository;
import com.scaler.LLDProject.ParkingLot.respository.Ticketrepository;
import com.scaler.LLDProject.ParkingLot.respository.VehicleRepository;
import com.scaler.LLDProject.ParkingLot.services.TicketService;
import com.scaler.LLDProject.ParkingLot.strategies.ParkingPlaceAllotmentStrategy;

import java.util.Date;
import java.util.UUID;

public class TicketServcieImpl implements TicketService {

    public GateRepository gateRepository;
    public VehicleRepository vehicleRepository;
    public ParkingLotRespository parkingLotRespository;

    public Ticketrepository ticketrepository;

    public TicketServcieImpl(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRespository parkingLotRespository, Ticketrepository ticketrepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRespository = parkingLotRespository;
        this.ticketrepository = ticketrepository;
    }

    @Override
    public Ticket issueTicket(IssueTicketRequest request) throws GateNotFoundException, ParkingLotException, ParkingLotFullException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        Gate gate = gateRepository.findGateById(request.getGateId());
        ticket.setGate(gate);
        Vehicle vehicle = vehicleRepository.getVehicleByNumber(request.getVehicleNumber());
        if (vehicle == null) {
            vehicle = new Vehicle(request.getVehicleNumber(), request.getVehicleType(), request.getOwner());
            vehicleRepository.save(vehicle);
        }
        ticket.setVehicle(vehicle);
        ParkingLot parkingLot = parkingLotRespository.getparkingLotId(request.getParkingLotId());
        ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy = request.getParkingPlaceAllotmentStrategy();
        ParkingSpot parkingSpot = parkingPlaceAllotmentStrategy.getParkingSpot(request.getVehicleType(), parkingLot);
        ticket.setParkingSpot(parkingSpot);
        ticket.setNumber(request.getVehicleNumber() + UUID.randomUUID());
        ticketrepository.save(ticket);
        return ticket;
    }
}
