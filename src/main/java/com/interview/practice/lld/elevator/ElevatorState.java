package com.interview.practice.lld.elevator;

public interface ElevatorState {
    void handle(Elevator elevator, ElevatorRequest request);
}
