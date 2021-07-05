package org.opentutorials.javatutorials.accessmodifier;

class A{
	public String y() {
		return "public void y()"; // Ŭ������ ������Ұ� public �̸� ������ �� ������Ҹ� ȣ�� �� �� �ִ�.
	}
	
	private String z() {
		return "public void z()"; // Ŭ������ ������Ұ� private(����������) �̸� 
								//Ŭ���� ���ο����� ������Ҹ� ȣ�� �� �� �ִ�.
								// Ŭ���� �ܺο��� ȣ�� �Ұ���
	}
	
	public String x() {
		return z(); // ���� Ŭ�������� private ������� ȣ�� ����
	}
}
public class AccessDemo1 {

	public static void main(String[] args) {
		A a = new A();
		
		System.out.println(a.y()); // public void y() ���� ���
		
		//System.out.println(a.z()); -> error -> 
		
		System.out.println(a.x()); // �ٸ� Ŭ������ private�� ���������� ȣ�� ����
	}

}

