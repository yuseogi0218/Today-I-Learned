package org.opentutorials.javatutorials.scope;

public class ScopeDemo2 {
	//클래스 변수 = 전역 변수 - global variables
	static int i;
	
	//클래스 메서드
	static void a() {
		// 변수 i는 어떠한 메서드의 소속도 아니다.
		// ScopeDemo2의 직접적인 소속인 클래스 변수
		// i = int i
		i = 0;
	}
	
	static void b() {
		// 지역 변수 생성
		int i = 0;
	}
	public static void main(String[] args) {
		for (i = 0; i<5; i++) {
			// i -> 선언 X, 전역변수를 가져와 씀.
			// i = int i = 0 -> 무한 반복
			a();
			System.out.println(i);
		}
		
		//-> 문제 없음.
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
