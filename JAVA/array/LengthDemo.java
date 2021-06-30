package org.opentutorials.javatutorials.array;

public class LengthDemo {

	public static void main(String[] args) {
		// 배열의 크기로 배열 생성
		String[] classGroup = new String[4];
		
		//배열에 값 추가
		classGroup[0] = "최진혁";
		classGroup[1] = "최유빈";
		classGroup[2] = "한이람";
		classGroup[3] = "이고잉";
		
		//배열 객체.length
		//배열의 크기 반환
		System.out.println(classGroup.length);

	}

}
