package org.opentutorials.javatutorials.operator;

public class PrePostDemo {

	public static void main(String[] args) {
		/*
		 * 단항 연산자
		 * + 양수 표현
		 * - 음수 표현
		 * ++ 증가 연산자 , 1씩 증가
		 * -- 감소 연산자, 1씩 감소
		 */
		
		int i = 3;
		i++; //i->4
		System.out.println(i);
		++i; // i->5
		System.out.println(i);
		System.out.println(++i); // i-> 6 
		System.out.println(i++); //6 출력, i->7
		System.out.println(i); // 7출력

	}

}
