package org.opentutorials.javatutorials.method;

public class MethodDemo1 {

	// method -> function(함수)
	
	//함수 정의
	public static void numbering() {
		int i =0;
		while(i<10) {
			System.out.println(i++);
		}
	}
	
	// 함수 호출
	public static void main(String[] args) {
		
		numbering();

	}

}
