package com.interview.practice.lld.elevator.service;

import com.interview.practice.lld.elevator.model.Elevator;
import com.interview.practice.lld.elevator.model.ElevatorRequest;

import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;
    private final ElevatorScheduler scheduler;

    public ElevatorController(List<Elevator> elevators, ElevatorScheduler scheduler) {
        this.elevators = elevators;
        this.scheduler = scheduler;
    }

    public Elevator processRequest(ElevatorRequest request) {
        Elevator elevator = scheduler.assignElevator(elevators, request);
        elevator.handleRequest(request);
        return elevator;
    }
}
