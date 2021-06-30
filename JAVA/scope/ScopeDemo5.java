package org.opentutorials.javatutorials.scope;

public class ScopeDemo5 {

	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			// for 문 안에서만 쓰이는 i생성
			System.out.println(i);
		}
		//System.out.println(i);
		//error ->for 문안에서만 i 존재
	}

}
