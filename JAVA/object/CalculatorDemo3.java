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
		// �߰��� �ٸ� ����� �������� ���� �ڵ尡 ���������� ���� �� �ִ�.
		// -> ��� ����� �����ϰ� �����ϰ� ���� �� �� �ִ� �۸��� �ʿ��ϴ�.
		
		// ���� ������ ������ �Լ��� �׷��� -> ��ü����
		
		sum(left, right);
		avg(left, right);
	}

}
