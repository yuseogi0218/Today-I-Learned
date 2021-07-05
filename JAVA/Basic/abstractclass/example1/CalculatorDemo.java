package org.opentutorials.javatutorials.abstractclass.example1;

abstract class Calculator{ //츠싱 메소드로 인하여 -> 클래스 -> 추상
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    } 
    
    int _sum() {
    	return this.left+ this.right;
    }
    int _avg() {
    	return (this.left+this.right)/2;
    }
    
    public abstract void sum();  
    public abstract void avg(); //-> 추상 메소드 -> 사용자가 작성
    
    public void run(){ //합계 평균 순차적 실행
        sum();
        avg();
    }
}


class CalculatorDecoPlus extends Calculator { //추상 클래스 상속
    public void sum(){
        System.out.println("+ sum :"+_sum()); // 추상 메소드 사용
    }
    public void avg(){
        System.out.println("+ avg :"+_avg());
    }
} 
class CalculatorDecoMinus extends Calculator {
    public void sum(){
        System.out.println("- sum :"+_sum());
    }
    public void avg(){
        System.out.println("- avg :"+_avg());
    }
} 


public class CalculatorDemo {
    public static void main(String[] args) { 
        CalculatorDecoPlus c1 = new CalculatorDecoPlus();
        c1.setOprands(10, 20);
        c1.run();
         
        CalculatorDecoMinus c2 = new CalculatorDecoMinus();
        c2.setOprands(10, 20);
        c2.run();
    }
   
}