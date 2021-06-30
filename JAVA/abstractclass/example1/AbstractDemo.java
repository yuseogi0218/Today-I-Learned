package org.opentutorials.javatutorials.abstractclass.example1;

abstract class A{ // 클래스의 멤버중 하나라도 abstract이면 -> 클래스는 abstract 이다.
    public abstract int b(); //-> 추상 메소드
    //본체가 있는 메소드는 abstract 키워드를 가질 수 없다.
    //public abstract int c(){System.out.println("Hello")}

    //추상 클래스 내에는 추상 메소드가 아닌 메소드가 존재 할 수 있다.
    public void d(){
        System.out.println("world");
    }
}
class B extends A {
    public int b() { // A클래스 내 abstract 메소드 B 를 써야 한다. -> 추상메소드는 상속하여 overriding 해야한다.
        return 1;
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        // A obj = new A();
        // -A 인스턴스화 error -> 클래스 A가 abstract 이기 때문에 -> 반드시 상속해서 가용해야함

        B obj = new B();

    }
}