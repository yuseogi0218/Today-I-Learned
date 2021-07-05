package org.opentutorials.javatutorials.scope;

public class ScopeDemo6 {
	//전역 변수
	static int i=5;
	
	static void a() {
		int i =10;
		b();
		
	}
	
	static void b() {
		//i = 5 - 전역변수 
		System.out.println(i);
		
	}
	
	public static void main(String[] args) {
		a();
		
	}

}
