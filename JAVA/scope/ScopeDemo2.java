package org.opentutorials.javatutorials.scope;

public class ScopeDemo2 {
	//Ŭ���� ���� = ���� ���� - global variables
	static int i;
	
	//Ŭ���� �޼���
	static void a() {
		// ���� i�� ��� �޼����� �Ҽӵ� �ƴϴ�.
		// ScopeDemo2�� �������� �Ҽ��� Ŭ���� ����
		// i = int i
		i = 0;
	}
	
	static void b() {
		// ���� ���� ����
		int i = 0;
	}
	public static void main(String[] args) {
		for (i = 0; i<5; i++) {
			// i -> ���� X, ���������� ������ ��.
			// i = int i = 0 -> ���� �ݺ�
			a();
			System.out.println(i);
		}
		
		//-> ���� ����.
		for (int i = 0; i<5; i++) {
			a();
			System.out.println(i);
		}
		
		for(i = 0; i<5; i++) {
			b();
			System.out.println(i);
		}
	}

}
