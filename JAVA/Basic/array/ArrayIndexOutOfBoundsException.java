package org.opentutorials.javatutorials.array;

public class ArrayIndexOutOfBoundsException {

	public static void main(String[] args) {
		// 자바 배열은 초기에 크기 지정후 변경 불가?
		
		//크기가 3인 배열 생성
		String[] members = new String[3];
		members[0] = "최진혁";
		members[1] = "최유빈";
		members[2] = "한이람";
		members[3] = "이고잉"; // 배열의 크기를 넘어서서 -> 에러 발생

		//collection이라는 기능으로 한계 극복
		//container 라고도 불림
	}

}
