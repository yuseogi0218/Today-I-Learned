package org.opentutorials.javatutorials.compare;

public class EqualStringDemo {

	public static void main(String[] args) {
		// ���ڿ� �� -> .equals
		String a = "Hello world";
        String b = new String("Hello world");
        System.out.println(a == b); // False
        System.out.println(a.equals(b)); // True

	}

}
