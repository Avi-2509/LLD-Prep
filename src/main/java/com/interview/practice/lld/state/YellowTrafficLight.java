package com.interview.practice.lld.state;

public class YellowTrafficLight implements TrafficState{
    @Override
    public void handleRequest(TrafficStateContext trafficStateContext) {
        System.out.println("Yellow state");
        trafficStateContext.setState(new GreenTrafficLight());
    }
}
