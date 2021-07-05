package org.opentutorials.javatutorials.conditionaloperator;

public class OrDemo {

	public static void main(String[] args) {
		// or -> ||
		// 둘중 하나라도 true -> true
		// 모두 false 일때 -> false
		if (true || true) {
            System.out.println(1);
        }
        if (true || false) {
            System.out.println(2);
        }
        if (false || true) {
            System.out.println(3);
        }
        if (false || false) {
            System.out.println(4);
        }

	}

}
