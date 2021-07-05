package org.opentutorials.javatutorials.scope;

public class ScopeDemo {
	
	static void a() {
		// 지역 변수 - local variables
		int i = 0;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i<5; i++) {
			a(); // a()의 i는 i안에서만 동작하도록 만들어짐.
			System.out.println(i);
		}
	}

}
