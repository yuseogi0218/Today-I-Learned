package org.opentutorials.javatutorials.object;

public class CalculatorDemo3 {
	public static void sum(int left, int right) {
		System.out.println(left + right);
	}
	
	public static void avg(int left, int right) {
		System.out.println((left+right)/2);
	}
	
	public static void main(String[] args) {
		int left, right;
		
		left = 20;
		right = 30;
		// 중간에 다른 사람의 개입으로 인해 코드가 복잡해지고 섞일 수 있다.
		// -> 모든 사람이 동일하게 동의하고 이해 할 수 있는 작명이 필요하다.
		
		// 서로 연관된 변수와 함수를 그루핑 -> 객체지향
		
		sum(left, right);
		avg(left, right);
	}

}
