package com.interview.practice.lld.elevator;

import com.interview.practice.lld.elevator.model.Direction;
import com.interview.practice.lld.elevator.model.Elevator;
import com.interview.practice.lld.elevator.model.ElevatorRequest;
import com.interview.practice.lld.elevator.model.RequestType;
import com.interview.practice.lld.elevator.service.ElevatorController;
import com.interview.practice.lld.elevator.service.ElevatorScheduler;
import com.interview.practice.lld.elevator.strategy.NearestElevatorStrategy;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Elevator e1 = new Elevator("E1");
        Elevator e2 = new Elevator("E2");
        Elevator e3 = new Elevator("E3");

        e1.setCurrentFloor(0);
        e2.setCurrentFloor(5);
        e3.setCurrentFloor(10);

        ElevatorController controller = new ElevatorController(
                List.of(e1, e2, e3),
                new ElevatorScheduler(new NearestElevatorStrategy())
        );

        ElevatorRequest externalRequest = new ElevatorRequest(6, Direction.UP, RequestType.EXTERNAL);
        Elevator assigned = controller.processRequest(externalRequest);

        System.out.println("Assigned Elevator: " + assigned.getId());
        System.out.println("Current Floor: " + assigned.getCurrentFloor());
        System.out.println("Direction: " + assigned.getDirection());
        System.out.println("Status: " + assigned.getStatus());
    }
}
