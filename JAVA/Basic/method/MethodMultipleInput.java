package org.opentutorials.javatutorials.method;

public class MethodMultipleInput {
	//함수 이름(입력 변수1, 입력 변수2)
	public static void numbering(int init, int limit) {
		while (init<limit) {
			System.out.println(init++);
		}
	}

	public static void main(String[] args) {
		numbering(5,10);

	}

}
