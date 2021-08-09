package com.company.design.decorator;

public class Car_1 extends CarDecorator{
    public Car_1(ICar car, String modelName) {
        super(car, modelName, 1000);
    }
}
