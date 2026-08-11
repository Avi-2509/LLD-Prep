package com.interview.practice.lld.parkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    HashMap<VehicleSize, List<ParkingSpot>> vehicleSizeListHashMap = new HashMap<>();
    HashMap<Vehicle, ParkingSpot> vehicleParkingSpotHashMap = new HashMap<>();

    public ParkingManager(HashMap<VehicleSize, List<ParkingSpot>> vehicleSizeListHashMap) {
        this.vehicleSizeListHashMap = vehicleSizeListHashMap;
        this.vehicleParkingSpotHashMap = new HashMap<>();
    }

    public ParkingSpot findSpotForVehicle(Vehicle vehicle){
        VehicleSize vehicleSize = vehicle.getVehicleSize();
        for(Map.Entry<VehicleSize, List<ParkingSpot>> entry: vehicleSizeListHashMap.entrySet()){
            if(entry.getKey() == vehicleSize){
                for(ParkingSpot parkingSpot: entry.getValue()){
                    if(parkingSpot.isAvailable()) return parkingSpot;
                }
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = findSpotForVehicle(vehicle);
        System.out.println("Found spot " + parkingSpot.getSpotNumber());
        if(parkingSpot != null){
            System.out.println("Found spot " + parkingSpot.getSpotNumber());
            parkingSpot.occupy(vehicle);
            vehicleSizeListHashMap.get(vehicle.getVehicleSize()).remove(parkingSpot);
            vehicleParkingSpotHashMap.put(vehicle, parkingSpot);
            return parkingSpot;
        }
        return null;
    }

    public void unParkVehicle(Vehicle vehicle){
        ParkingSpot parkingSpot = vehicleParkingSpotHashMap.get(vehicle);
        if(parkingSpot != null){
            parkingSpot.release();
            vehicleParkingSpotHashMap.remove(vehicle);
        }
    }
}
