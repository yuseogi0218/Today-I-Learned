package org.opentutorials.javatutorials.polymorphism;

import java.util.ArrayList;

interface I2{
    public String A();
}
interface I3{
    public String B();
}
class D implements I2, I3{ // 클래스 D는 interface I2,I3를 구현 -> 각 interface가 강제하고있는 메소드 구현화
    public String A(){
        return "A";
    }
    public String B(){
        return "B";
    }
}
public class PolymorphismDemo3 {
    public static void main(String[] args) {
        D obj = new D(); // D라는 클래스를 obj로 인스턴스화 , 데이터 타입 - D
        I2 objI2 = new D(); //D라는 클래스를 objI2로 인스턴스화, 데이터 타입 - I2(D라는 클래스가 구현하고있는 인터페이스 중 하나)
        I3 objI3 = new D(); //D라는 클래스를 objI3로 인스턴스화, 데이터 타입 - I3( " )
         
        obj.A();
        obj.B(); // -> obj의 데이터 타입이 D이기 때문에 클래스 D의 메소드를 아무 문제없이 사용
         
        objI2.A();
        //objI2.B(); // -> obj2의 데이터 타입이 I2이기 때문에 I2의 메소드 - A만 사용 가능
         
        //objI3.A();
        objI3.B(); // -> obj3의 데이터 타입이 I3이기 때문에 I3의 메소드 - B만 사용 가능
    }
}

//한개의 interface를 다양한 class가 다르게 구현하고 -> 동일한 interface를 데이터 타입으로 인스턴스화 시킬때 다양하게 구현 가능하다.
// -> 각각의 class 에서 서로 다르게 구현하였기 때문에 -> 다형성