package org.opentutorials.javatutorials.overloading.example1;

public class OverloadingDemo2 extends OverloadingDemo{
    void A (String arg1, String arg2){System.out.println("sub class : void A (String arg1, String arg2)");}
    // -> �޼ҵ� �����ε� - ���� �̸� �ٸ� �޼ҵ忡 ���ؼ� �������� �޼ҵ带 ����  
    void A (){System.out.println("sub class : void A ()");} // �θ� Ŭ������ �ִ°Ϳ� ����� -> �������̵�
    public static void main(String[] args) {
        OverloadingDemo2 od = new OverloadingDemo2();
        od.A();
        od.A(1);
        od.A("coding everybody");
        od.A("coding everybody", "coding everybody");
         
    }
}