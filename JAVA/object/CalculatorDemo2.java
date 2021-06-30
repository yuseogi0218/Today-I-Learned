package org.opentutorials.javatutorials.object;

public class CalculatorDemo2 {
	//CalculatorDemo1 의 중복 제거 
	// -> 메소드 활용 -> refactoring
	// ->이유 : 유연해지고, 버그 낮춤
	
	public static void sum(int left, int right) {
		System.out.println(left + right);
	}
	
	public static void main(String[] args) {
		sum(10,20);
		sum(20,40);
	}

}
