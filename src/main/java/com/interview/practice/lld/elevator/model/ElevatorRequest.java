package com.interview.practice.lld.elevator.model;

public class ElevatorRequest {
    private final int floor;
    private final Direction direction;
    private final RequestType requestType;

    public ElevatorRequest(int floor, Direction direction, RequestType requestType) {
        this.floor = floor;
        this.direction = direction;
        this.requestType = requestType;
    }

    public int getFloor() { return floor; }
    public Direction getDirection() { return direction; }
    public RequestType getRequestType() { return requestType; }
}
