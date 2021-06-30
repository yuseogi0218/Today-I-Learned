package org.opentutorials.javatutorials.classinstance;

class Calculator {
	// 클래스 변수 - 모든 인스턴스가 동일한 값을 가질때 
	static double PI = 3.14;
	// static 한 변수 -> 클래스의 소속이 된다. -> 모든 인스턴스에서 동일한 값을 가진다.
	
	int left, right;
	
	//인스턴스 변수 - 인스턴스가 각각의 변수값을 가질때
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left+ this.right)/2);
	}
	
}


public class CalculatorDemo1 {

	public static void main(String[] args) {
		//클래스 변수 가져와 쓰기
		
		//인스턴스 사용
		Calculator c1 = new Calculator();
		System.out.println(c1.PI);
		
		Calculator c2 = new Calculator();
		System.out.println(c2.PI);
		
		// 클래스 사용하여 직접적인 접근
		System.out.println(Calculator.PI);
		
	}

}
