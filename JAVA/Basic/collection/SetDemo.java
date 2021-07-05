package org.opentutorials.javatutorials.collection;

import java.util.ArrayList;
import java.util.HashSet;
 
import java.util.Iterator;
 
public class SetDemo {
 
    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
         
        HashSet<Integer> B = new HashSet<Integer>();
        B.add(3);
        B.add(4);
        B.add(5);
         
        HashSet<Integer> C = new HashSet<Integer>();
        C.add(1);
        C.add(2);
         
        System.out.println(A.containsAll(B)); // false B�� A�� �κ������� �ƴ�
        System.out.println(A.containsAll(C)); // true C�� A�� �κ�������.
         
        //A.addAll(B); // ������
        //A.retainAll(B); // ������
        //A.removeAll(B); // A-B
         
        
        /*- Iterator
        *     - CoolectionsFramework�� �ִ�  ���� �ϳ��ϳ� ������ �ݺ��Ͽ� ó���ϵ��� �ϴ� ������ Ÿ��
        *     - �޼ҵ�
        *         - hasNext()
        *             - Iterator ��ü �� ���� ������ True ��ȯ 
        *         - next()
        *             - Iterator ��ü�� ����ִ� �� �� �ϳ��� ����
        *             - ������ ���� Iterator ��ü���� ����
        */
        Iterator hi = A.iterator(); // collectionsframework ��ü.iterator() -> Iterator ������Ÿ���� ��ü ����
        // Iterator ��ü - collectionsframework ��ü�� ������ ���� ���� �迭?
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }
 
}