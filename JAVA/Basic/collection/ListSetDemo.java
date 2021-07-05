package org.opentutorials.javatutorials.collection;
/*
 * List VS Set
 * - List
 *     - �ߺ� ����
 *     - ������ ����
 * - Set
 *     - �ߺ� �Ұ���
 *     - ������ ���� - �ε��� X 
 */
import java.util.ArrayList;
import java.util.HashSet;
 
import java.util.Iterator;
 
public class ListSetDemo {
 
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("two");
        al.add("three");
        al.add("three");
        al.add("five");
        System.out.println("array");
        Iterator ai = al.iterator();
        while(ai.hasNext()){
            System.out.println(ai.next());
        }
         
        HashSet<String> hs = new HashSet<String>(); // HashSet ���� -> HashSet<������Ÿ��> ��ü �̸� = new HashSet<������Ÿ��>();
        hs.add("one");
        hs.add("two");
        hs.add("two"); // �ߺ��̱� ������ �߰� ���� ����.
        hs.add("three");
        hs.add("three");
        hs.add("five");
        Iterator hi = hs.iterator();
        System.out.println("\nhashset");
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }
 
}