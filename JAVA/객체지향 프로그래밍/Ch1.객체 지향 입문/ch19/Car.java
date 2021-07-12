package Chapter2.ch19;

public class Car {

    private static int serialNum = 10000;
    private int CarNum;

    public Car() {
        serialNum ++;
        CarNum = serialNum;
    }

    public int getCarNum() {
        return CarNum;
    }

}
