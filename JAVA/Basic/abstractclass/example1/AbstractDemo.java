package org.opentutorials.javatutorials.abstractclass.example1;

abstract class A{ // Ŭ������ ����� �ϳ��� abstract�̸� -> Ŭ������ abstract �̴�.
    public abstract int b(); //-> �߻� �޼ҵ�
    //��ü�� �ִ� �޼ҵ�� abstract Ű���带 ���� �� ����.
    //public abstract int c(){System.out.println("Hello")}

    //�߻� Ŭ���� ������ �߻� �޼ҵ尡 �ƴ� �޼ҵ尡 ���� �� �� �ִ�.
    public void d(){
        System.out.println("world");
    }
}
class B extends A {
    public int b() { // AŬ���� �� abstract �޼ҵ� B �� ��� �Ѵ�. -> �߻�޼ҵ�� ����Ͽ� overriding �ؾ��Ѵ�.
        return 1;
    }
}
public class AbstractDemo {
    public static void main(String[] args) {
        // A obj = new A();
        // -A �ν��Ͻ�ȭ error -> Ŭ���� A�� abstract �̱� ������ -> �ݵ�� ����ؼ� �����ؾ���

        B obj = new B();

    }
}