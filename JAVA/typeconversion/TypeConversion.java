package org.opentutorials.javatutorials.typeconversion;

public class TypeConversion {

	public static void main(String[] args) {
		// �ڵ�(�Ͻ���) �� ��ȯ
		// �ڵ� �� ��ȯ�� ��Ģ�� ǥ�������� ���� ������ Ÿ�Կ��� ���� ������ Ÿ�������� ��ȯ�� ���ȴٴ� ���̴�.
		// byte -> short -> int -> long -> float -> double
		//			chr  -> int -> long -> float -> double
		int a = 3;
		float b = 1.0F;
		double c = a+b; 
		// a+b : int + float -> float + float = float
		//double c = -> float -> double
		
		// ����(�����) �� ��ȯ
		// (������ Ÿ��)������ ��
		float d = (float)100.0; // (float)double -> float
		int e = (int)100.0F; // (int)float -> int

	}

}
