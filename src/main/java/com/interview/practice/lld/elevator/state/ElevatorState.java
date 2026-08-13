package com.interview.practice.lld.elevator.state;

import com.interview.practice.lld.elevator.model.Elevator;
import com.interview.practice.lld.elevator.model.ElevatorRequest;

public interface ElevatorState {
    void handle(Elevator elevator, ElevatorRequest request);
}
