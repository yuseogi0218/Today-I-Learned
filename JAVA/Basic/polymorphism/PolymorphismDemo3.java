package org.opentutorials.javatutorials.polymorphism;

import java.util.ArrayList;

interface I2{
    public String A();
}
interface I3{
    public String B();
}
class D implements I2, I3{ // Ŭ���� D�� interface I2,I3�� ���� -> �� interface�� �����ϰ��ִ� �޼ҵ� ����ȭ
    public String A(){
        return "A";
    }
    public String B(){
        return "B";
    }
}
public class PolymorphismDemo3 {
    public static void main(String[] args) {
        D obj = new D(); // D��� Ŭ������ obj�� �ν��Ͻ�ȭ , ������ Ÿ�� - D
        I2 objI2 = new D(); //D��� Ŭ������ objI2�� �ν��Ͻ�ȭ, ������ Ÿ�� - I2(D��� Ŭ������ �����ϰ��ִ� �������̽� �� �ϳ�)
        I3 objI3 = new D(); //D��� Ŭ������ objI3�� �ν��Ͻ�ȭ, ������ Ÿ�� - I3( " )
         
        obj.A();
        obj.B(); // -> obj�� ������ Ÿ���� D�̱� ������ Ŭ���� D�� �޼ҵ带 �ƹ� �������� ���
         
        objI2.A();
        //objI2.B(); // -> obj2�� ������ Ÿ���� I2�̱� ������ I2�� �޼ҵ� - A�� ��� ����
         
        //objI3.A();
        objI3.B(); // -> obj3�� ������ Ÿ���� I3�̱� ������ I3�� �޼ҵ� - B�� ��� ����
    }
}

//�Ѱ��� interface�� �پ��� class�� �ٸ��� �����ϰ� -> ������ interface�� ������ Ÿ������ �ν��Ͻ�ȭ ��ų�� �پ��ϰ� ���� �����ϴ�.
// -> ������ class ���� ���� �ٸ��� �����Ͽ��� ������ -> ������