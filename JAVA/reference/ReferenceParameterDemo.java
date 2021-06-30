package org.opentutorials.javatutorials.reference;
//메소드의 매개변수와 참조,복제
public class ReferenceParameterDemo {
    
    static void _value(int b){
        b = 2;
    }
     
    public static void runValue(){
        int a = 1;
        _value(a); // -> int b = a != int a;
        System.out.println("runValue, "+a);
    }
     
    static void _reference1(A b){ //-> A b = a;
        b = new A(2); // 새로운 객체-new A(2) 참조
    }
     
    public static void runReference1(){
        A a = new A(1); // -> 참조 관계, a.id = 1 
        _reference1(a);// -> a가 참조하는것에는 변화를 주지 않음
        System.out.println("runReference1, "+a.id);     
    }
     
    static void _reference2(A b){ //-> A b = a;
        b.id = 2; // b.id = 2 = a.id 
    }
 
    public static void runReference2(){
        A a = new A(1); // a.id = 1
        _reference2(a); // a.id = 2
        System.out.println("runReference2, "+a.id);     
    }
     
    public static void main(String[] args) {
        runValue(); // runValue, 1
        runReference1(); // runReference1, 1
        runReference2(); // runReference2, 2
    }
 
}
