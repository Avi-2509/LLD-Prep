package com.interview.practice.lld.state;

public class RedLightTrafficState implements TrafficState{
    @Override
    public void handleRequest(TrafficStateContext trafficStateContext) {
        System.out.println("Red Light");
        trafficStateContext.setState(new YellowTrafficLight());
    }
}
