package org.opentutorials.javatutorials.overloading.example1;

// 매개변수는 같지만 리턴타입이 다르면 오류 발생 

public class OverloadingDemo {
    void A (){System.out.println("void A()");}
    void A (int arg1){System.out.println("void A (int arg1)");}
    // void A (int param1){System.out.println("void A (int arg1)");} -> 리턴타입이 같지만 매개변수의 이름이 다름
    void A (String arg1){System.out.println("void A (String arg1)");} // 매개변수는 다르지만 리턴타입이 같음
    //int A (){System.out.println("void A()");} -> 매개변수는 같지만 리턴타입이 다름
    public static void main(String[] args) {
        OverloadingDemo od = new OverloadingDemo();
        od.A();
        od.A(1);
        od.A("coding everybody");
    }
}