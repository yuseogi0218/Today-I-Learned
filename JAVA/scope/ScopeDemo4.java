package org.opentutorials.javatutorials.scope;

public class ScopeDemo4 {

	static void a() {
		String title = "code everybody";
	}
	
	public static void main(String[] args) {
		a();
		//System.out.println(title);
		// error -> a()�ȿ����� ����������, main �ȿ����� title�� �������� �ʴ�.
	}

}
