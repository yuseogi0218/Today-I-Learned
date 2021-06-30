package org.opentutorials.javatutorials.reference;
//�޼ҵ��� �Ű������� ����,����
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
        b = new A(2); // ���ο� ��ü-new A(2) ����
    }
     
    public static void runReference1(){
        A a = new A(1); // -> ���� ����, a.id = 1 
        _reference1(a);// -> a�� �����ϴ°Ϳ��� ��ȭ�� ���� ����
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
