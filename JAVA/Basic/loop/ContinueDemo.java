package org.opentutorials.javatutorials.loop;

public class ContinueDemo {

	public static void main(String[] args) {
		// continue
		// ������ ��� �ߴ��ϸ鼭 �ݺ��� �����ذ���
		for(int i =0; i <10; i++) {
			if (i==5) { 
				continue;
			}
			System.out.println("Coding Everybody " + i);
			//i==5 �϶� ���� X
		}

	}

}
