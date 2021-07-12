package Chapter2.ch19;

import Chapter2.ch18.Company;

public class CarFactory {

    private static CarFactory instance  = new CarFactory();

    public static CarFactory getInstance() {
        if (instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    public static Car createCar() {
        Car car = new Car();
        return car;
    }


}
