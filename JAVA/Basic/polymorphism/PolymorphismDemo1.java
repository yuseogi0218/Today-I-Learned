package org.opentutorials.javatutorials.polymorphism;

// 클래스와 다형성

class A{
    public String x(){return "x";}
}

class B extends A{ //A 클래스 상속
	public String x() {return "B.x";}
    public String y(){return "y";} // 인스턴스시 데이터 타입을 부모A로 한다면 존재하지 않는 메소드가 된다.
}

class B2 extends A{
	public String x() {return "B2.x";}
}

public class PolymorphismDemo1 {
    public static void main(String[] args) {
        A obj = new B(); // 클래스 B를 obj에 인스턴스화 시켜서 담음 / obj의 데이터 타입 = A  -> A의 행세를 하고 있다.
        // 결론 : 어떠한 클래스를 인스턴스화 시킬때, 그 인스턴스를 담는 데이터 타입 은 그 클래스 본인이 될 수 도 있고, 그 클래스의 부모 클래스가 될 수 도 있다.
        // 데이터 타입을 부모클래스로 했을때 효과 : 인스턴스가 부모인거처럼 동작 가능하다.
        
        System.out.println(obj.x());
        // -> obj.x() = 클래스 B의 메소드 x() 실행
        // 결론 : 인스턴스화 시킨 obj의 데이터 타입이 A일지라도, 클래스 B에 있는 메소드가 상위인 클래스 A의 메소드를 오버라이딩 했다면
        // -> 클래스 B의 메소드를 실행 시킨다.
        
        //obj.y(); -> obj의 데이터 타입이 A이기 때문에 메소드 y가 존재하지 않는다고 생각
        
        A obj2 = new B2();
        System.out.println(obj2.x()); // B1과 B2의 결과가 다르게 나온다. -> 다른 형태로 사용할 수 있다.?
    }
}
//다형성 - 서로 다른 객체가 동일한 데이터 타입 으로 존재하면서 각각의 클래스에 정의되어있는 메소드를 호출할때는 
	//  각각의 클래스에 소속되어있는 메소드의 방식대로 동작한다.