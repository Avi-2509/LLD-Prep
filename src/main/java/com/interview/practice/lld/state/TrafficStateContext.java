package com.interview.practice.lld.state;

public class TrafficStateContext {
    private TrafficState currentTrafficState;

    TrafficStateContext(){
        currentTrafficState = new RedLightTrafficState();
    }

    void setState(TrafficState trafficState){
        this.currentTrafficState = trafficState;
    }

    void changeLight(){
        currentTrafficState.handleRequest(this);
    }
}
