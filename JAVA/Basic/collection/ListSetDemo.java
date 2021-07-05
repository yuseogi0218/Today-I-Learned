package org.opentutorials.javatutorials.collection;
/*
 * List VS Set
 * - List
 *     - 중복 가능
 *     - 순서가 있음
 * - Set
 *     - 중복 불가능
 *     - 순서가 없음 - 인덱스 X 
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
         
        HashSet<String> hs = new HashSet<String>(); // HashSet 생성 -> HashSet<데이터타입> 객체 이름 = new HashSet<데이터타입>();
        hs.add("one");
        hs.add("two");
        hs.add("two"); // 중복이기 때문에 추가 되지 않음.
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