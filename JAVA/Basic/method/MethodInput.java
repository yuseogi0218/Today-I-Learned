package org.opentutorials.javatutorials.method;

public class MethodInput {
	//�Լ� �̸�(�Է� ����)
	// �Է� ���� -> �Ű����� = parameter
	public static void numbering(int limit) {
        int i = 0;
        while (i < limit) {
            System.out.println(i);
            i++;
        }
    }

	public static void main(String[] args) {
		// �Լ� �̸�(����);
		// ���� = argument
		numbering(5);

	}

}
