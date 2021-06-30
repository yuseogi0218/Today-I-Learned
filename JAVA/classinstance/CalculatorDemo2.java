package org.opentutorials.javatutorials.classinstance;

class Calculator2 {
    static double PI = 3.14;
    
    // 클래스 변수인 base가 추가되었다.
    // -> 클래스의 맴버
    static int base = 0;
    int left, right;
 
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        // 더하기에 base의 값을 포함시킨다.
        System.out.println(this.left + this.right + base);
    }
 
    public void avg() {
        // 평균치에 base의 값을 포함시킨다.
        System.out.println((this.left + this.right + base) / 2);
    }
}
 
public class CalculatorDemo2 {
 
    public static void main(String[] args) {
 
        Calculator2 c1 = new Calculator2();
        c1.setOprands(10, 20);
        // 30 출력
        c1.sum();
 
        Calculator2 c2 = new Calculator2();
        c2.setOprands(20, 40);
        // 60 출력
        c2.sum();
 
        // 클래스 변수 값 변경 가능
        // 클래스 변수 base의 값을 10으로 지정했다.
        Calculator2.base = 10;
 
        // 40 출력
        c1.sum();
 
        // 70 출력
        c2.sum();
 
    }
 
}
