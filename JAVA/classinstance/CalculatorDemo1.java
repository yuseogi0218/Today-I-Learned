package org.opentutorials.javatutorials.classinstance;

class Calculator {
	// Ŭ���� ���� - ��� �ν��Ͻ��� ������ ���� ������ 
	static double PI = 3.14;
	// static �� ���� -> Ŭ������ �Ҽ��� �ȴ�. -> ��� �ν��Ͻ����� ������ ���� ������.
	
	int left, right;
	
	//�ν��Ͻ� ���� - �ν��Ͻ��� ������ �������� ������
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
		//Ŭ���� ���� ������ ����
		
		//�ν��Ͻ� ���
		Calculator c1 = new Calculator();
		System.out.println(c1.PI);
		
		Calculator c2 = new Calculator();
		System.out.println(c2.PI);
		
		// Ŭ���� ����Ͽ� �������� ����
		System.out.println(Calculator.PI);
		
	}

}
