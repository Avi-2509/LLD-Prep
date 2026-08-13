package com.interview.practice.lld.elevator.state;

import com.interview.practice.lld.elevator.model.Direction;
import com.interview.practice.lld.elevator.model.Elevator;
import com.interview.practice.lld.elevator.model.ElevatorRequest;
import com.interview.practice.lld.elevator.model.ElevatorStatus;

public class MovingState implements ElevatorState {
    @Override
    public void handle(Elevator elevator, ElevatorRequest request) {
        elevator.setStatus(ElevatorStatus.MOVING);
        elevator.setCurrentFloor(request.getFloor());
        elevator.setStatus(ElevatorStatus.STOPPED);
        elevator.setDirection(Direction.IDLE);
        elevator.setState(new IdleState());
    }
}
