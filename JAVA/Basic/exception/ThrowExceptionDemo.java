package org.opentutorials.javatutorials.exception;

class B{
    void run(){
    	//if ���� �߻��� -> C���� throw ���� 
    }
}
class C{
    void run(){
        B b = new B();
        b.run(); // B�� throw�� error�� try~catch or throw(main method ����)
    }
}

public class ThrowExceptionDemo {
    public static void main(String[] args) {
         C c = new C();
         c.run(); // C�� throw�� error�� try~catch or throw(error�߻�)
    }   
}