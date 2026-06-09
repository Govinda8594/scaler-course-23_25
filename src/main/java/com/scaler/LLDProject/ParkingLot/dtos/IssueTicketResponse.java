package com.scaler.LLDProject.ParkingLot.dtos;


import com.scaler.LLDProject.ParkingLot.models.Ticket;

public class IssueTicketResponse {
    private Ticket ticket;
    private String message;
    ;
    private String response;

    public IssueTicketResponse(Ticket ticket, String message, String response) {
        this.ticket = ticket;
        this.message = message;
        this.response = response;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
