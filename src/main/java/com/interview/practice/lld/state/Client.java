package com.interview.practice.lld.state;

public class Client {
    public static void main(String[] args) {
        TrafficStateContext trafficStateContext = new TrafficStateContext();
        for(int i = 0; i < 6; i++){
            trafficStateContext.changeLight();
        }
    }
}
