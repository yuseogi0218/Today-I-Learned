package org.opentutorials.javatutorials.scope;

public class ScopeDemo {
	
	static void a() {
		// ���� ���� - local variables
		int i = 0;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i<5; i++) {
			a(); // a()�� i�� i�ȿ����� �����ϵ��� �������.
			System.out.println(i);
		}
	}

}
