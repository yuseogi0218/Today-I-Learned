package com.company.design.decorator;

public class CarDecorator implements ICar {

    protected ICar car;
    protected String modelName;
    protected int modelPrice;

    public CarDecorator(ICar car, String modelName, int modelPrice) {
        this.car = car;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice() {
        return car.getPrice() + modelPrice; // decorator 패턴 적용
    }

    @Override
    public void showPrice() {
        System.out.println(modelName + "의 가격은 " + getPrice() + "원 입니다.");
    }
}
