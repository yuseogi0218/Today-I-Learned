package org.opentutorials.javatutorials.scope;

public class ScopeDemo5 {

	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			// for �� �ȿ����� ���̴� i����
			System.out.println(i);
		}
		//System.out.println(i);
		//error ->for ���ȿ����� i ����
	}

}
