package com.interview.practice.lld.elevator;

public class Elevator {
    private final String id;
    private int currentFloor;
    private Direction direction;
    private ElevatorStatus status;
    private ElevatorState state;

    public Elevator(String id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.status = ElevatorStatus.STOPPED;
        this.state = new IdleState();
    }

    public void handleRequest(ElevatorRequest request) {
        state.handle(this, request);
    }

    public String getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }
    public ElevatorStatus getStatus() { return status; }

    public void setCurrentFloor(int currentFloor) { this.currentFloor = currentFloor; }
    public void setDirection(Direction direction) { this.direction = direction; }
    public void setStatus(ElevatorStatus status) { this.status = status; }
    public void setState(ElevatorState state) { this.state = state; }
}
