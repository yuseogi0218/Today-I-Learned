package org.opentutorials.javatutorials.io;

//
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		//System.in = 사용자가 입력한 값
		//Scanner(System.in) = 사용자가 입력한 값 을 스캔(알아내는)역할을 함
		//Scanner(파일) = 파일을 스캔하는 역할
		int i = sc.nextInt();
		// nextInt = 입력값이 숫자여야 한다
		// sc.nextInt() = 정지 되었다가 -> 공백이 입력되면 -> 다시 실행 
		System.out.println("입력한 숫자 : " + i);
		sc.close();
		

	}

}
