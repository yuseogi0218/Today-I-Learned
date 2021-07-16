package Chapter3.ch10;

public abstract class Car {

    public abstract void drive();
    public abstract void stop();
    // 필요시 기능을 추가하면 된다.

    public void startCar() {
        System.out.println("시동을 켭니다.");
    }

    public void turnOff() {
        System.out.println("시동을 끕니다.");
    }

    public void washCar() {}

    // 하위 클래스에서 재정의 못하게 함
    final public void run() {
        startCar();
        drive();
        stop();
        turnOff();
        washCar();
    }
}
