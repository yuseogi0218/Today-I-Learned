package org.opentutorials.javatutorials.overloading.example1;

public class OverloadingDemo2 extends OverloadingDemo{
    void A (String arg1, String arg2){System.out.println("sub class : void A (String arg1, String arg2)");}
    // -> 메소드 오버로딩 - 같은 이름 다른 메소드에 의해서 여러개의 메소드를 정의  
    void A (){System.out.println("sub class : void A ()");} // 부모 클래스에 있는것에 덮어쓰기 -> 오버라이딩
    public static void main(String[] args) {
        OverloadingDemo2 od = new OverloadingDemo2();
        od.A();
        od.A(1);
        od.A("coding everybody");
        od.A("coding everybody", "coding everybody");
         
    }
}