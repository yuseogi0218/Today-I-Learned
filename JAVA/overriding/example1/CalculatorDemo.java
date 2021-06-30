package org.opentutorials.javatutorials.overriding.example1;

/*overriding - 재정의
 * 부모가 물려준 클래스 또는 메소드를 자식 클래스에서 덮어쓰기 하여 자식 클래스만의 독자적으로 재정의
 * 
 * 조건 - 메소드의 서명(signature) 일치
 * - 메소드의 이름
 * - 메소드 매개변수의 숫자와 데이터 타입 그리고 순서
 * - 메소드의 리턴 타입
 */
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
 
class SubstractionableCalculator extends Calculator {
     
    public void sum() {
        System.out.println("실행 결과는 " +(this.left + this.right)+"입니다.");
    } // 부모클래스의 sum() 메소드를 overriding -> 메소드 overriding 
     
    /*
     *  public int avg() {
        return (this.left + this.right)/2;
    } -> error -> 메소드의 리턴 타입 불 일치 -> 조건 불 충족
     */
    
    public void substract() {
        System.out.println(this.left - this.right);
    }
}
 
public class CalculatorDemo {
    public static void main(String[] args) {
        SubstractionableCalculator c1 = new SubstractionableCalculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}