package com.interview.practice.lld.elevator.state;

import com.interview.practice.lld.elevator.model.Direction;
import com.interview.practice.lld.elevator.model.Elevator;
import com.interview.practice.lld.elevator.model.ElevatorRequest;
import com.interview.practice.lld.elevator.model.ElevatorStatus;

public class IdleState implements ElevatorState {
    @Override
    public void handle(Elevator elevator, ElevatorRequest request) {
        elevator.setStatus(ElevatorStatus.MOVING);
        elevator.setDirection(request.getFloor() > elevator.getCurrentFloor() ? Direction.UP : Direction.DOWN);
        elevator.setState(new MovingState());
        elevator.setCurrentFloor(request.getFloor());
        elevator.setStatus(ElevatorStatus.STOPPED);
        elevator.setDirection(Direction.IDLE);
        elevator.setState(new IdleState());
    }
}
