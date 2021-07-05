package org.opentutorials.javatutorials.generic;
/*
 * ������ ���ʸ�
 * - <�̸�1, �̸�2,...> -> �̸��� �޶�� �Ѵ�.
 *     - �߰��� ","�� �����Ѵ�.
 * 
 * ���ʸ� Ư¡
 * <������  Ÿ��> - ������ ������ Ÿ�Ը� �� �� �ִ�. - int �Ұ���
 *     - �⺻ ������ Ÿ���� ���� ���ؼ��� wrapper Ŭ����
 *         - �⺻ ������ Ÿ���� ��ġ ��ü �ΰ�ó�� ���� �� �ִ� ��ü���� ����
 *         - 
 *         - int -> Integer, double -> Double, ... 
 */

/*
 * ���ʸ��� ���� �����ϴ�
 */

/*
 * ���ʸ��� Ŭ�����Ӹ� �ƴ϶� �޼ҵ� ���������� ����Ҽ� �ִ�.
 */

class EmployeeInfo5{
    public int rank;
    EmployeeInfo5(int rank){ this.rank = rank; }
}
class Person5<T, S>{
    public T info;
    public S id;
    Person5(T info, S id){ 
        this.info = info; 
        this.id = id;
    }
    public <U> void printInfo(U info){
        System.out.println(info);
    }// �޼ҵ� �������� ���ʸ� ���
}


public class GenericDemo5 {
    public static void main(String[] args) {
    	EmployeeInfo e = new EmployeeInfo(1);
    	Integer i =new Integer(10);
    	Person5 p1 = new Person5(e, i); // ���ʸ� ���� ����
        // = Person5<EmployeeInfo, Integer> p1 = new Person5<EmployeeInfo, Integer>(e, i);
    	
    	// �޼ҵ� ���������� ���ʸ� ȣ��
    	// p1.<EmployeeInfo>printInfo(e);//<������ Ÿ��>�޼ҵ�(); -> <������ Ÿ��> ���� ����
    	p1.printInfo(e);
    }
}
