package org.opentutorials.javatutorials.loop;

public class ContinueDemo {

	public static void main(String[] args) {
		// continue
		// 실행을 즉시 중단하면서 반복은 지속해가게
		for(int i =0; i <10; i++) {
			if (i==5) { 
				continue;
			}
			System.out.println("Coding Everybody " + i);
			//i==5 일때 실행 X
		}

	}

}
