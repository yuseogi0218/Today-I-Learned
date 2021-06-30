package org.opentutorials.javatutorials.accessmodifier;

class A{
	public String y() {
		return "public void y()"; // 클래스의 구성요소가 public 이면 누구나 그 구성요소를 호출 할 수 있다.
	}
	
	private String z() {
		return "public void z()"; // 클래스의 구성요소가 private(접근제어자) 이면 
								//클래스 내부에서만 구성요소를 호출 할 수 있다.
								// 클래스 외부에서 호출 불가능
	}
	
	public String x() {
		return z(); // 같은 클래스내의 private 구성요소 호출 가능
	}
}
public class AccessDemo1 {

	public static void main(String[] args) {
		A a = new A();
		
		System.out.println(a.y()); // public void y() 정상 출력
		
		//System.out.println(a.z()); -> error -> 
		
		System.out.println(a.x()); // 다른 클래스의 private를 간접적으로 호출 가능
	}

}

