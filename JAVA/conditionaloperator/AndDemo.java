package org.opentutorials.javatutorials.conditionaloperator;

public class AndDemo {

	public static void main(String[] args) {
		// and -> && 
		// ��� true �϶� -> true
		// ��� �ϳ��� false �϶� -> false
		if (true && true) {
            System.out.println(1);
        }
 
        if (true && false) {
            System.out.println(2);
        }
 
        if (false && true) {
            System.out.println(3);
        }
 
        if (false && false) {
            System.out.println(4);
        }

	}

}
