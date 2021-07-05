package org.opentutorials.javatutorials.io;

import java.util.Scanner;

public class Scanner2Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // System.in -> 사용자 입력
		while(sc.hasNextInt()) { //hasNextInt : 숫자 입력 -> true
			System.out.println("입력한 숫자 :"+ sc.nextInt());
		
		}
		sc.close();
		System.out.println("입력값이 Int가 아닙니다.");

	}

}
