package org.opentutorials.javatutorials.overloading.example1;

// �Ű������� ������ ����Ÿ���� �ٸ��� ���� �߻� 

public class OverloadingDemo {
    void A (){System.out.println("void A()");}
    void A (int arg1){System.out.println("void A (int arg1)");}
    // void A (int param1){System.out.println("void A (int arg1)");} -> ����Ÿ���� ������ �Ű������� �̸��� �ٸ�
    void A (String arg1){System.out.println("void A (String arg1)");} // �Ű������� �ٸ����� ����Ÿ���� ����
    //int A (){System.out.println("void A()");} -> �Ű������� ������ ����Ÿ���� �ٸ�
    public static void main(String[] args) {
        OverloadingDemo od = new OverloadingDemo();
        od.A();
        od.A(1);
        od.A("coding everybody");
    }
}