package org.opentutorials.javatutorials.method;

public class MethodMultipleReturn {
	//return �� ������ ��ȯ�ϱ�
	//�迭 ����ϱ�
	//�Լ� ����
	// -> public static String[] �Լ� �̸�
	// 					- �迭
	
	public static String[] getMembers() {
        String[] members = { "������", "������", "���̶�" };
        return members;
    }
	
	

	public static void main(String[] args) {
		//�Լ� ���
		String[] members = getMembers();
		
		//���
		for (String e : members) {
			System.out.println(e);
		}

	}

}
