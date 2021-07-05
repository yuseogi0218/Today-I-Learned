package org.opentutorials.javatutorials.Inheritance.example3;

class Calculator5 {
    int left, right;
     
    /*public Calculator(int left, int right){
    	this.left = left;
        this.right = right;
    } -> 에러 발생 = 부모 클래스에서 매개변수가 있는 생성자를 선언하면, 하위클래스에서 부모의 기본 생성자를 호출 할 수 없다. ->  기본 생성자를 명시적으로 선언하라는 에러 발생
    */
    
    public Calculator5() {} //해결 -> 부모 클래스에서 기본 생성자를 정의
     
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
 
class SubstractionableCalculator5 extends Calculator5 {// 부모 클래스인 Calculator 의 생성자를 자동으로 호출 
    public SubstractionableCalculator5(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void substract() {
        System.out.println(this.left - this.right);
    }
}
 
public class CalculatorConstructorDemo5 {
    public static void main(String[] args) {
        SubstractionableCalculator5 c1 = new SubstractionableCalculator5(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}

//상위 클래스와 하위 클래스에 생성자들이 하는 일이 같다면-> 상위클래스의 생성자를 하위클래스 생성자에서 호출한다면 -> 해결 -> super()