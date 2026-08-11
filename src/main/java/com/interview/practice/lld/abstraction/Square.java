package com.interview.practice.lld.abstraction;

public class Square extends Shape{
    private Integer length;
    public Square(String color, Integer length){
        super(color);
        this.length = length;
    }
    @Override
    void calculateArea() {
        System.out.println("Area for Square is " + length * length);
    }
}
