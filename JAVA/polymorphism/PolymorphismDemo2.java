package org.opentutorials.javatutorials.polymorphism;

interface I{} // interface 

class C implements I{} // 클래스 C가 interface I구현

public class PolymorphismDemo2 {
    public static void main(String[] args) {
        I obj = new C();
        // 클래스 C를 인스턴스화 시킬때, 객체의 데이터 타입으로 클래스 C가 구현하고 있는 interface를 지정할 수 있다.
    }
}