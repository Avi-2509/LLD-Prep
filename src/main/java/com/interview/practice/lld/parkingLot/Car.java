package com.interview.practice.lld.parkingLot;

public class Car implements Vehicle{
    String numberPlate;

    public Car(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return VehicleSize.SMALL;
    }

    @Override
    public String getNumberPlate() {
        return this.numberPlate;
    }
}
