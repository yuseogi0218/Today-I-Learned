package org.opentutorials.javatutorials.method;

public class MethodMultipleInput {
	//�Լ� �̸�(�Է� ����1, �Է� ����2)
	public static void numbering(int init, int limit) {
		while (init<limit) {
			System.out.println(init++);
		}
	}

	public static void main(String[] args) {
		numbering(5,10);

	}

}
