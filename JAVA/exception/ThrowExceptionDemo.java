package org.opentutorials.javatutorials.exception;

class B{
    void run(){
    	//if 예외 발생시 -> C에게 throw 가능 
    }
}
class C{
    void run(){
        B b = new B();
        b.run(); // B가 throw한 error를 try~catch or throw(main method 에게)
    }
}

public class ThrowExceptionDemo {
    public static void main(String[] args) {
         C c = new C();
         c.run(); // C가 throw한 error를 try~catch or throw(error발생)
    }   
}