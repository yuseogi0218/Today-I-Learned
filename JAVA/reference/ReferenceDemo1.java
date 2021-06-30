package org.opentutorials.javatutorials.reference;

class A{
    public int id;
    A(int id){
        this.id = id;
    }
}
public class ReferenceDemo1 {
 
    public static void runValue(){
        int a = 1; //�⺻�� -> ���� �߻� 
        int b = a; // a = 1 
        b = 2;
        System.out.println("runValue, "+a); 
    }
     
    public static void runReference(){
        A a = new A(1); // ������ -> ��ü�� ��ġ���� ������ �ִ�.
        A b = a; // a.id = 2
        b.id = 2;
        System.out.println("runReference, "+a.id);      
    }
 
    public static void main(String[] args) {
        runValue();
        runReference();
    }
 
}

// new �� ���ؼ� ������ ������ ���� ������ ������ Ÿ�� �̴�.
// �⺻ ������ Ÿ�� �� ������ ������ Ÿ���� �ٸ��� �����Ѵ�.

/*
 * ������ ������ ����
 * - ����
 *     - �ٷΰ���
 *     - ���� ����� -> �ٷΰ���(����)�� ���� O
 *     - �������� �޸� ���
 * - ����
 *     - ����
 *     - ���� ���� ���� ����� ���纻 ���� X
 */