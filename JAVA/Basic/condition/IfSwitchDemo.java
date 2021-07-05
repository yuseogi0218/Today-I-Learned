package org.opentutorials.javatutorials.condition;

public class IfSwitchDemo {

	public static void main(String[] args) {
		//if-else ¹®
		int val = 1;
        if(val == 1){
            System.out.println("one");
        } else if(val == 2){
            System.out.println("two");
        } else if(val == 2){
            System.out.println("three");
        }
        
        System.out.println();
        
        //switch ¹®
        switch(val) {
        case 1:
        	System.out.println("one");
        	break;
        case 2:
        	System.out.println("two");
        	break;
        case 3:
        	System.out.println("three");
        	break;
        }

	}

}
