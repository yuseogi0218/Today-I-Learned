package org.opentutorials.javatutorials.condition;

public class SwitchDemo {

	public static void main(String[] args) {
		System.out.println("switch(1)");
        // case 1 이후의 모든 것 실행
		switch(1){
        case 1:
            System.out.println("one");
        case 2:
            System.out.println("two");
        case 3:
            System.out.println("three");
        }
		
		System.out.println();
		// case 2 이후의 모든것 실행
		System.out.println("switch(2)");
		switch(2) {
		case 1:
            System.out.println("one");
        case 2:
            System.out.println("two");
        case 3:
            System.out.println("three");
		}
		
		System.out.println();
		
		//break를 만나면 switch 문의 실행이 즉시 중지된다.
		System.out.println("switch(2) - break");
        switch(2){
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
