package org.opentutorials.javatutorials.io;

//
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		//System.in = ����ڰ� �Է��� ��
		//Scanner(System.in) = ����ڰ� �Է��� �� �� ��ĵ(�˾Ƴ���)������ ��
		//Scanner(����) = ������ ��ĵ�ϴ� ����
		int i = sc.nextInt();
		// nextInt = �Է°��� ���ڿ��� �Ѵ�
		// sc.nextInt() = ���� �Ǿ��ٰ� -> ������ �ԷµǸ� -> �ٽ� ���� 
		System.out.println("�Է��� ���� : " + i);
		sc.close();
		

	}

}
