package org.opentutorials.javatutorials.object;

public class CalculatorDemo2 {
	//CalculatorDemo1 �� �ߺ� ���� 
	// -> �޼ҵ� Ȱ�� -> refactoring
	// ->���� : ����������, ���� ����
	
	public static void sum(int left, int right) {
		System.out.println(left + right);
	}
	
	public static void main(String[] args) {
		sum(10,20);
		sum(20,40);
	}

}
