package org.opentutorials.javatutorials.method;

public class MethodInput {
	//함수 이름(입력 변수)
	// 입력 변수 -> 매개변수 = parameter
	public static void numbering(int limit) {
        int i = 0;
        while (i < limit) {
            System.out.println(i);
            i++;
        }
    }

	public static void main(String[] args) {
		// 함수 이름(인자);
		// 인자 = argument
		numbering(5);

	}

}
