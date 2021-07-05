package org.opentutorials.javatutorials.classinstance;

class Calculator3{
	
	//클래스 메서드 생성
	//public static ...
    public static void sum(int left, int right){
        System.out.println(left+right);
    }
     
    public static void avg(int left, int right){
        System.out.println((left+right)/2);
    }
}
 
public class CalculatorDemo3 {
     
    public static void main(String[] args) {
    	//클래스 메서드 호출
    	// -> 클래스.메서드 이름
        Calculator3.sum(10, 20);
        Calculator3.avg(10, 20);
         
        Calculator3.sum(20, 40);
        Calculator3.avg(20, 40);
    }
 
}