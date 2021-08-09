package com.company.design.decorator;

public class Car implements ICar {

    private int price;

    public Car(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("car 의 가격은 " + this.price + " 원 입니다.");
    }
}
