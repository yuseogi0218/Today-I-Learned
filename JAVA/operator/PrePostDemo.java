package org.opentutorials.javatutorials.operator;

public class PrePostDemo {

	public static void main(String[] args) {
		/*
		 * ���� ������
		 * + ��� ǥ��
		 * - ���� ǥ��
		 * ++ ���� ������ , 1�� ����
		 * -- ���� ������, 1�� ����
		 */
		
		int i = 3;
		i++; //i->4
		System.out.println(i);
		++i; // i->5
		System.out.println(i);
		System.out.println(++i); // i-> 6 
		System.out.println(i++); //6 ���, i->7
		System.out.println(i); // 7���

	}

}
