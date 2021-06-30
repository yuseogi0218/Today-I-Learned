package org.opentutorials.javatutorials.scope;
class C{
	//전역 변수
	int v = 10;
	
	void m() {
		//지역변수
		int v = 20;
		System.out.println(v);
	}
	
	void n() {
		int v = 30;
		//this.v = c1.v
		System.out.println(this.v);
	}
}

public class ScopeDemo7 {

	public static void main(String[] args) {
		C c1 = new C();
		c1.m();
		
		c1.n();
	}

}
