package org.opentutorials.javatutorials.method;

public class MethodReturn {
	//�Լ� ������ public static ����� ���� �Լ� �̸�
	
	//public static String �Լ��̸�
	// -> String ������ ����� ��ȯ
	
	//public static void �Լ��̸�
	// -> �����(return)�� �������� ����
	
	public static String numbering(int init, int limit) {
		String output = "";
		while(init < limit) {
			output += init;
			init++;
			
		}
		
		return output; //return�� ������ �� ��ȯ �� �Լ� ����
	}
	
	

	public static void main(String[] args) {
		String result = numbering(1,5);
		System.out.println(result);

	}

}
