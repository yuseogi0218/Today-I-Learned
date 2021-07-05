package org.opentutorials.javatutorials.object;


	class Calculator{
		// 클래스 - 객체 - 설계도
	    int left, right;
	      
	    public void setOprands(int left, int right){
	        this.left = left;
	        // this.변수 = 객체의 변수.변수
	        // = 인스턴스 이름.변수
	        this.right = right;
	    }
	      
	    public void sum(){
	        System.out.println(this.left+this.right);
	    }
	      
	    public void avg(){
	        System.out.println((this.left+this.right)/2);
	    }
	}
	  
	public class CalculatorDemo4 {
	      
	    public static void main(String[] args) {
	          
	        Calculator c1 = new Calculator(); 
	        // 인스턴스 - 설계도에 의해 만들어진 제품
	        //calculator() - 객체 <=> 클래스
	        // 객체 호출 -> 인스턴스 생성
	        //데이터타입 인스턴스이름 = new 객체이름();
	        c1.setOprands(10, 20);
	        c1.sum();       
	        c1.avg();       
	        // 객체 내 메소드 호출
	        // 객체변수.메소드();
	          
	        Calculator c2 = new Calculator();
	        // 또 다른 인스턴스 생성
	        c2.setOprands(20, 40);
	        c2.sum();       
	        c2.avg();
	    }
}
