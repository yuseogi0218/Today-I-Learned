package org.opentutorials.javatutorials.io;

import java.util.Scanner;

public class Scanner2Demo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // System.in -> ����� �Է�
		while(sc.hasNextInt()) { //hasNextInt : ���� �Է� -> true
			System.out.println("�Է��� ���� :"+ sc.nextInt());
		
		}
		sc.close();
		System.out.println("�Է°��� Int�� �ƴմϴ�.");

	}

}
