package com.company.design;

import com.company.design.aop.AopBrowser;
import com.company.design.decorator.*;

public class Main {

    public static void main(String[] args) {

        /**
         * decorator
         */
        ICar car = new Car(1000);
        car.showPrice();

        // car_1
        ICar car1 = new Car_1(car, "car_1");
        car1.showPrice();

        // car_2
        ICar car2 = new Car_2(car, "car_2");
        car2.showPrice();

        // car_3
        ICar car3 = new Car_3(car, "car_3");
        car3.showPrice();
    }
}
