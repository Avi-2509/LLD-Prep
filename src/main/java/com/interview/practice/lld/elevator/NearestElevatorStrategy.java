package com.interview.practice.lld.elevator;

import java.util.Comparator;
import java.util.List;

public class NearestElevatorStrategy implements DispatchStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, ElevatorRequest request) {
        return elevators.stream()
                .filter(e -> e.getStatus() != ElevatorStatus.MAINTENANCE)
                .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - request.getFloor())))
                .orElseThrow(() -> new IllegalStateException("No available elevator"));
    }
}
