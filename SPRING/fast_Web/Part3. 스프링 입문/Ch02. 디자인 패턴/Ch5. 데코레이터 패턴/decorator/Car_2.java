package com.company.design.decorator;

public class Car_2 extends CarDecorator{
    public Car_2(ICar car, String modelName) {
        super(car, modelName, 2000);
    }
}
