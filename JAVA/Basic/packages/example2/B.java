package org.opentutorials.javatutorials.packages.example2;
import org.opentutorials.javatutorials.packages.example1.A; // 로드하고 싶은 클래스 import 

public class B {
	public static void main(String[] args) {
		A a = new A(); //다른 패키지 내에 있는 클래스 로드  
	}
}
