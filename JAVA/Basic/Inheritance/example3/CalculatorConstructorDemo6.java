package org.opentutorials.javatutorials.Inheritance.example3;

class Calculator {
    int left, right;
     
    public Calculator(int left, int right){
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
class SubstractionableCalculator extends Calculator {
    public SubstractionableCalculator(int left, int right) {
        super(left, right); // -> super - 부모 클래스 (left, right);
        // super() -> 브모클래스의 생성자
        // 하위클래스가 상위클래스를 참조할 수 있는 방법 
        
        //하위 클래스의 추가 초기화코드는 super() 뒤에 있어야한다. 
    }
 
    public void substract() {
        System.out.println(this.left - this.right);
    }
}
 
public class CalculatorConstructorDemo6 {
    public static void main(String[] args) {
        SubstractionableCalculator c1 = new SubstractionableCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}