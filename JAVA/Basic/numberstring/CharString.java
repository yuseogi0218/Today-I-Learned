package org.opentutorials.javatutorials.numberstring;

public class CharString {

	public static void main(String[] args) {
		// '����' 'A'  ,  "���ڿ�" "AB" "A"
		System.out.println('��'); // -> ����
		System.out.println("��"); // -> ���ڿ�
		System.out.println("���ڿ�"); // -> ���ڿ�
		// System.out.println('���ڿ�'); -> ����
		System.out.println();
		
		// ���ڿ� ���ϱ�
		System.out.println("��Ȱ�ڵ�" + "�Դϴ�.");
		System.out.println(1+1); // 2 - ����
		System.out.println("1" + "1"); // "11" - ���ڿ�
		System.out.println();
		
		// �̽������� - \_
		// ����ǥ - \' \"
		System.out.println("egoing said\"welcome programming world\"");
		// ���� �� - \n
		System.out.println("HTML\nCSS\nJavaScript");
		

	}

}
