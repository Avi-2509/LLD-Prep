package com.interview.practice.lld.elevator;

import java.util.List;

public interface DispatchStrategy {
    Elevator selectElevator(List<Elevator> elevators, ElevatorRequest request);
}
