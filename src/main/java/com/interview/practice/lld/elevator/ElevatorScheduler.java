package com.interview.practice.lld.elevator;

import java.util.List;

public class ElevatorScheduler {
    private final DispatchStrategy dispatchStrategy;

    public ElevatorScheduler(DispatchStrategy dispatchStrategy) {
        this.dispatchStrategy = dispatchStrategy;
    }

    public Elevator assignElevator(List<Elevator> elevators, ElevatorRequest request) {
        return dispatchStrategy.selectElevator(elevators, request);
    }
}
