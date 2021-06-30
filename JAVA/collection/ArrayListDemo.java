package org.opentutorials.javatutorials.collection;
/*
 * collectionsframework
 * - �迭�� ������ �� �ذ�
 *     - �迭�� �ѹ� �����ϸ� �� ũ�⸦������ �� ���ٴ� ��
 * - �������
 *     - Collection
 *         - Set
 *             - �ߺ��Ǹ� �ȵȴ�.
 *         - List
 *             - �ߺ� ���� 
 *             - ArrayList
 *         - Queue
 *     - Map
 *         - key : value ������ ���� ����
 *         
 * 
 */
import java.util.ArrayList;

public class ArrayListDemo {
 
    public static void main(String[] args) {
        String[] arrayObj = new String[2];
        arrayObj[0] = "one";
        arrayObj[1] = "two";
        // arrayObj[2] = "three"; ������ �߻��Ѵ�. -> ũ�⸦ ���.
        for(int i=0; i<arrayObj.length; i++){
            System.out.println(arrayObj[i]);
        }
         
        /*
         * ArrayList
         * - �迭���� �ٸ��� ������ ũ�� ���� X
         */
        ArrayList al = new ArrayList(); // ���� - ArrayList ��ü �̸� = new ArrayList();
        al.add("one"); // �� �߰� -> ��� �������� Ÿ�Ե� ���� ���� -> ������ Ÿ�� - Object
        al.add("two");
        al.add("three");
        for(int i=0; i<al.size(); i++){ // ArrayList ũ�� = ��ü �̸�.size();
        	Object value = al.get(i);// �ε��� i �� ��ȯ - al.get(i) -> ������ Ÿ�� - Object
        	//or
        	String value_str = (String)al.get(i);
            System.out.println(value); 
            
        }
        // or generic Ȱ��
        ArrayList<String> al2 = new ArrayList<String>(); 
        al2.add("one"); 
        al2.add("two");
        al2.add("three");
        for(int i=0; i<al.size(); i++){ 
        	String value2 = al2.get(i); // generic�� ���ؼ� ������ Ÿ���� String ���� ���� -> ����ȯ �ʿ� X
        	System.out.println(value2);
        }
    }
 
}