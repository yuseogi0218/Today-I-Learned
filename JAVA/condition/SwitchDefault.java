package org.opentutorials.javatutorials.condition;

public class SwitchDefault {

	public static void main(String[] args) {
		// else <-> default
		System.out.println("switch(4)");
        switch(4){
        case 1:
            System.out.println("one");
            break;
        case 2:
            System.out.println("two");
            break;
        case 3:
            System.out.println("three");
            break;
        default:
            System.out.println("default");
            break;
        }

	}

}
