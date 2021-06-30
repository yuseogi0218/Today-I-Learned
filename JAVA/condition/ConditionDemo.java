package org.opentutorials.javatutorials.condition;

public class ConditionDemo {

	public static void main(String[] args) {
		if(true) {
			System.out.println("result : true");
		}
		
		System.out.println();
		
		if(false) {
			System.out.println("result : true");
		}
		System.out.println("result : false");

		System.out.println();
		//if - else
		if(false) {
			System.out.println("result : true");
		} else {
			System.out.println("result : false");
		}
		
		System.out.println();
		//if - else if - else
		if(false) {
			System.out.println("result : true");
		} else if(false) {
			System.out.println("result : true");
		} else {
			System.out.println("result : false");
		}
	}

}
