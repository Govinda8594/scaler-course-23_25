package com.scaler.LLDProject.ParkingLot.controller;

import com.scaler.LLDProject.ParkingLot.dtos.IssueTicketRequest;
import com.scaler.LLDProject.ParkingLot.dtos.IssueTicketResponse;
import com.scaler.LLDProject.ParkingLot.exceptions.GateNotFoundException;
import com.scaler.LLDProject.ParkingLot.exceptions.ParkingLotException;
import com.scaler.LLDProject.ParkingLot.exceptions.ParkingLotFullException;
import com.scaler.LLDProject.ParkingLot.models.Ticket;
import com.scaler.LLDProject.ParkingLot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponse issueTicket(IssueTicketRequest request) {
        Ticket ticket = null;
        try {
            ticket = ticketService.issueTicket(request);
        } catch (GateNotFoundException exception) {
            System.out.println("Gate not found: " + exception.getMessage());
            return new IssueTicketResponse(null, "FAILURE", "Invalid gate");
        } catch (ParkingLotException exception) {
            System.out.println("parkingLot not found: " + exception.getMessage());
            return new IssueTicketResponse(null, "FAILURE", "invalid parking");
        } catch (ParkingLotFullException e) {
            System.out.println("parkingLotfull: " + e.getMessage());
            return new IssueTicketResponse(null, "FAILURE", "Parking full");
        }
        return new IssueTicketResponse(ticket, "SUCCESS", "Ticket Generated");
    }
}
