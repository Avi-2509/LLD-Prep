package com.interview.practice.lld.elevator.strategy;

import com.interview.practice.lld.elevator.model.Elevator;
import com.interview.practice.lld.elevator.model.ElevatorRequest;

import java.util.List;

public interface DispatchStrategy {
    Elevator selectElevator(List<Elevator> elevators, ElevatorRequest request);
}
