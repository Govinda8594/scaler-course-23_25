package com.scaler.LLDProject.ParkingLot.services;


import com.scaler.LLDProject.ParkingLot.dtos.IssueTicketRequest;
import com.scaler.LLDProject.ParkingLot.exceptions.GateNotFoundException;
import com.scaler.LLDProject.ParkingLot.exceptions.ParkingLotException;
import com.scaler.LLDProject.ParkingLot.exceptions.ParkingLotFullException;
import com.scaler.LLDProject.ParkingLot.models.Ticket;

public interface TicketService {
    Ticket issueTicket(IssueTicketRequest request) throws GateNotFoundException, ParkingLotException, ParkingLotFullException;
}
