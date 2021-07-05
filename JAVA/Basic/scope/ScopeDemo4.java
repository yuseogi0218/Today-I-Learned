package org.opentutorials.javatutorials.scope;

public class ScopeDemo4 {

	static void a() {
		String title = "code everybody";
	}
	
	public static void main(String[] args) {
		a();
		//System.out.println(title);
		// error -> a()안에서는 존재하지만, main 안에서는 title이 존재하지 않다.
	}

}
