package com.interview.practice.lld.parkingLot;

public class CompactParkingSpot implements ParkingSpot{
    String spotNumber;
    Vehicle vehicle;

    public CompactParkingSpot(String spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public Boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if(isAvailable()){
            this.vehicle = vehicle;
        }
    }

    @Override
    public void release() {
        this.vehicle = null;
    }

    @Override
    public String getSpotNumber() {
        return spotNumber;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.SMALL;
    }
}
