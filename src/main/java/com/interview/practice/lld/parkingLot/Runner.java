package com.interview.practice.lld.parkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car("UP70DM8592");
        Vehicle vehicle2 = new Car("UP70DM8591");

        ParkingSpot parkingSpot1 = new CompactParkingSpot("id123");
        ParkingSpot parkingSpot2 = new CompactParkingSpot("id124");
        ParkingSpot parkingSpot3 = new CompactParkingSpot("id125");
        ParkingSpot parkingSpot4 = new CompactParkingSpot("id126");

        HashMap<VehicleSize, List<ParkingSpot>> vehicleSizeListHashMap = new HashMap<>();
        vehicleSizeListHashMap.put(VehicleSize.SMALL, new ArrayList<>());
        vehicleSizeListHashMap.get(VehicleSize.SMALL).addAll(Arrays.asList(parkingSpot1, parkingSpot2,
                parkingSpot3, parkingSpot4));
        ParkingManager parkingManager = new ParkingManager(vehicleSizeListHashMap);
        FareProcessor fareProcessor = new FareProcessor();

        ParkingLot parkingLot = new ParkingLot(parkingManager, fareProcessor);
        parkingLot.parkVehicle(vehicle1);
        parkingLot.parkVehicle(vehicle2);



    }
}
