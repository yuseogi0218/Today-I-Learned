package org.opentutorials.javatutorials.generic;
//generic = 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
class Person<T>{
    public T info; // T - info필드의 데이터 타입 - Person클래스 정의시 T를 명시적으로 지정 X
}
 
public class GenericDemo {
 
    public static void main(String[] args) {
        Person<String> p1 = new Person<String>(); // Person을 인스턴스화 할때, 데이터 타입을 정함
        Person<StringBuilder> p2 = new Person<StringBuilder>();
        //데이터 타입 객체 = new 데이터타입();
    }
 
}