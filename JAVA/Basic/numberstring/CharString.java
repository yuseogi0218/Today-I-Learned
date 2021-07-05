package org.opentutorials.javatutorials.numberstring;

public class CharString {

	public static void main(String[] args) {
		// '문자' 'A'  ,  "문자열" "AB" "A"
		System.out.println('생'); // -> 문자
		System.out.println("생"); // -> 문자열
		System.out.println("문자열"); // -> 문자열
		// System.out.println('문자열'); -> 에러
		System.out.println();
		
		// 문자열 더하기
		System.out.println("생활코딩" + "입니다.");
		System.out.println(1+1); // 2 - 숫자
		System.out.println("1" + "1"); // "11" - 문자열
		System.out.println();
		
		// 이스케이프 - \_
		// 따옴표 - \' \"
		System.out.println("egoing said\"welcome programming world\"");
		// 다음 줄 - \n
		System.out.println("HTML\nCSS\nJavaScript");
		

	}

}
