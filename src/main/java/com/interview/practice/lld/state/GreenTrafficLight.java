package com.interview.practice.lld.state;

public class GreenTrafficLight implements TrafficState{
    @Override
    public void handleRequest(TrafficStateContext trafficStateContext) {
        System.out.println("Green light");
        trafficStateContext.setState(new RedLightTrafficState());
    }
}
