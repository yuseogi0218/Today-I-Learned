package org.opentutorials.javatutorials.polymorphism;

abstract class Calculator{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    } 
    int _sum() {
        return this.left + this.right;
    }
    public abstract void sum();  
    public abstract void avg(); // abstract 이기 때문에 내용이 없음
    
    public void run(){ // sum(), avg()호출하는 구체적인 메소드
        sum();
        avg();
    }
    
}
class CalculatorDecoPlus extends Calculator {
    public void sum(){
        System.out.println("+ sum :"+_sum());
    }
    public void avg(){
        System.out.println("+ avg :"+(this.left+this.right)/2);
    }
} 

class CalculatorDecoMinus extends Calculator {
    public void sum(){
        System.out.println("- sum :"+_sum());
    }
    public void avg(){
        System.out.println("- avg :"+(this.left+this.right)/2);
    }
} 
public class CalculatorDemo {
	public static void execute(Calculator cal) {
		System.out.println("실행 결과");
		cal.run();
	}
	
    public static void main(String[] args) { 
        Calculator c1 = new CalculatorDecoPlus(); // -> 부모 클래스가 인스턴스화된 객체의 데이터 타입이다.
        c1.setOprands(10, 20);
        c1.run();
         
        Calculator c2 = new CalculatorDecoMinus();
        c2.setOprands(10, 20);
        c2.run();
     // c1과 c2의 데이터 타입은 같지만, 두 객체의 클래스모두 run()의 sum(),age()를 각각 가지고 있기 때문에 서로 다르게 실행된다.
        
        execute(c1);
        execute(c2); 
    // 다형성의 사용 예시 -> 두 객체 모두 run을 하고 있기 때문에 이것을 메소드화 시켜서 중복성을 제거해준다.
        
    } 
    
   
}