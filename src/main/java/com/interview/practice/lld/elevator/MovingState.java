package com.interview.practice.lld.elevator;

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
