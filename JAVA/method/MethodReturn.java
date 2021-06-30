package org.opentutorials.javatutorials.method;

public class MethodReturn {
	//함수 생성시 public static 결과값 형태 함수 이름
	
	//public static String 함수이름
	// -> String 형태의 결과값 반환
	
	//public static void 함수이름
	// -> 결과값(return)은 존재하지 않음
	
	public static String numbering(int init, int limit) {
		String output = "";
		while(init < limit) {
			output += init;
			init++;
			
		}
		
		return output; //return을 만나면 값 반환 후 함수 종료
	}
	
	

	public static void main(String[] args) {
		String result = numbering(1,5);
		System.out.println(result);

	}

}
