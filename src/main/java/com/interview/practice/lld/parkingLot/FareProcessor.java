package com.interview.practice.lld.parkingLot;

import java.time.LocalDateTime;
import java.util.HashMap;

public class FareProcessor {
    HashMap<Vehicle, Ticket> vehicleTicketHashMap = new HashMap<>();

    public Ticket createTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        if(!vehicleTicketHashMap.containsKey(vehicle)){
            Ticket ticket = Ticket.builder()
                    .id(12)
                    .vehicle(vehicle)
                    .parkingSpot(parkingSpot)
                    .entryTime(LocalDateTime.now())
                    .build();
            vehicleTicketHashMap.put(vehicle, ticket);
            System.out.println("Ticket created " + vehicle.getNumberPlate() + " " + ticket.getId());
            return ticket;
        }
        return vehicleTicketHashMap.get(vehicle);
    }
}
