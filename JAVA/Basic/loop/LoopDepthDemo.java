package org.opentutorials.javatutorials.loop;

public class LoopDepthDemo {

	public static void main(String[] args) {
		//�ݺ����� ��ø
		for(int i = 1; i<10; i++) {
			for(int j = 1
					; j<10; j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}

	}

}
