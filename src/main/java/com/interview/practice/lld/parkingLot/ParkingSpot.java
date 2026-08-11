package com.interview.practice.lld.parkingLot;

import java.util.Vector;

public interface ParkingSpot {
    Boolean isAvailable();
    Vehicle getVehicle();
    void occupy(Vehicle vehicle);
    void release();
    String getSpotNumber();
    VehicleSize getVehicleSize();
}
