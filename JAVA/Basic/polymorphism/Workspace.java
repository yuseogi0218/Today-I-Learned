package org.opentutorials.javatutorials.polymorphism;

interface father{}
interface mother{}
interface programmer{
    public void coding();
}
interface believer{}

class Steve implements father, programmer, believer{ // Steve 클래스는 father, programmer, beliver 구현
    public void coding(){
        System.out.println("fast");
    }
}

class Rachel implements mother, programmer{ // Rachel 클래스는 mother, programmer 구현
    public void coding(){
        System.out.println("elegance");
    }
}

public class Workspace{ //직장
    public static void main(String[] args){
        programmer employee1 = new Steve(); // Steve를 employee1으로 인스턴스화, 데이터타입 - programmer
        programmer employee2 = new Rachel(); // Rachel을 employee2로 인스턴스화, 데이터타입 - programmer
         // 직장에서는 Steve,Rachel의 programming외의 다른 interface를 모른다.
        
        employee1.coding();
        employee2.coding(); // 동일한 메소드 이름이지만, 결과는 각각의 클래스(Steve, Rachel)에 의해서 다르다. - 다형성
    }
}