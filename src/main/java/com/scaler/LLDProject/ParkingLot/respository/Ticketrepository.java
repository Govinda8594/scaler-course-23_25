package com.scaler.LLDProject.ParkingLot.respository;


import com.scaler.LLDProject.ParkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class Ticketrepository {
    private Map<String, Ticket> ticketMap = new HashMap<String, Ticket>();

    public Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<String, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }

    public void save(Ticket ticket) {
        ticketMap.put(ticket.getNumber(), ticket);
    }
}
