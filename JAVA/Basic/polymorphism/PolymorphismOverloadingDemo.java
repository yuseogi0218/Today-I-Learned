package org.opentutorials.javatutorials.polymorphism;

class O{
    public void a(int param){
        System.out.println("숫자출력");
        System.out.println(param);
    }
    
    public void a(String param){
        System.out.println("문자출력");
        System.out.println(param);
    }
}
public class PolymorphismOverloadingDemo {
    public static void main(String[] args) {
        O o = new O();
        o.a(1);
        o.a("one");
    }
}

//다형성의 가장 쉬운 예제 -> overloading
// -> 같은 이름 다른 매개변수에 따라서 다른 내용을 갖고있음.