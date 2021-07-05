package org.opentutorials.javatutorials.generic;
//generic = Ŭ���� ���ο��� ����� ������ Ÿ���� �ܺο��� �����ϴ� ���
class Person<T>{
    public T info; // T - info�ʵ��� ������ Ÿ�� - PersonŬ���� ���ǽ� T�� ��������� ���� X
}
 
public class GenericDemo {
 
    public static void main(String[] args) {
        Person<String> p1 = new Person<String>(); // Person�� �ν��Ͻ�ȭ �Ҷ�, ������ Ÿ���� ����
        Person<StringBuilder> p2 = new Person<StringBuilder>();
        //������ Ÿ�� ��ü = new ������Ÿ��();
    }
 
}