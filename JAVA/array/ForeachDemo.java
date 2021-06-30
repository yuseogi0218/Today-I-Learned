package org.opentutorials.javatutorials.array;

public class ForeachDemo {

	public static void main(String[] args) {
		//for문과 배열의 결합을 단순하게 표현
		String[] members = {"최진혁","최유빈","한이람"};
		for (String e : members) {
			System.out.println(e + "이 상담을 받았습니다.");
		}

	}

}
