package org.opentutorials.javatutorials.Inheritance.example1;

class Calculator {
    int left, right;
 
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}
 
//추가 클래스 정의 + extends 부모 클래스 -> 확장
class SubstractionableCalculator extends Calculator {
    public void substract() {
        System.out.println(this.left - this.right);
    }
}
 
public class CalculatorDemo1 {
 
    public static void main(String[] args) {
 
        SubstractionableCalculator c1 = new SubstractionableCalculator();
        //확장으로 인하여 Calculator로 부터 상속받은 메서드 사용
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        
        c1.substract();
    }
 
}