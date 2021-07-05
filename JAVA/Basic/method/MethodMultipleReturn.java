package org.opentutorials.javatutorials.method;

public class MethodMultipleReturn {
	//return 값 여러개 반환하기
	//배열 사용하기
	//함수 정의
	// -> public static String[] 함수 이름
	// 					- 배열
	
	public static String[] getMembers() {
        String[] members = { "최진혁", "최유빈", "한이람" };
        return members;
    }
	
	

	public static void main(String[] args) {
		//함수 사용
		String[] members = getMembers();
		
		//출력
		for (String e : members) {
			System.out.println(e);
		}

	}

}
