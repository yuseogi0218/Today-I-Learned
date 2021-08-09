package com.company.design.decorator;

public class Car_3 extends CarDecorator{
    public Car_3(ICar car, String modelName) {
        super(car, modelName, 3000);
    }
}
