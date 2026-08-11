package com.interview.practice.lld.parkingLot;

public class ParkingLot {
    ParkingManager parkingManager;
    FareProcessor fareProcessor;

    public ParkingLot(ParkingManager parkingManager, FareProcessor fareProcessor) {
        this.parkingManager = parkingManager;
        this.fareProcessor = fareProcessor;
    }

    public void parkVehicle(Vehicle vehicle){
        System.out.println("Trying to park vehicle");
        ParkingSpot parkingSpot = parkingManager.parkVehicle(vehicle);
        fareProcessor.createTicket(vehicle,parkingSpot );
    }
}
