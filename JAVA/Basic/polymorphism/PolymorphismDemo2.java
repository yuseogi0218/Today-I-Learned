package org.opentutorials.javatutorials.polymorphism;

interface I{} // interface 

class C implements I{} // Ŭ���� C�� interface I����

public class PolymorphismDemo2 {
    public static void main(String[] args) {
        I obj = new C();
        // Ŭ���� C�� �ν��Ͻ�ȭ ��ų��, ��ü�� ������ Ÿ������ Ŭ���� C�� �����ϰ� �ִ� interface�� ������ �� �ִ�.
    }
}