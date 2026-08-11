package com.interview.practice.lld.parkingLot;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public class Ticket {
    int id;
    Vehicle vehicle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    ParkingSpot parkingSpot;
    LocalDateTime entryTime;

    public Integer calculateParkedTime(){
        return LocalDateTime.now().getMinute() - entryTime.getMinute();
    }
}


