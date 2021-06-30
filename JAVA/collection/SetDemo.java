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
         
        System.out.println(A.containsAll(B)); // false B는 A의 부분집합이 아님
        System.out.println(A.containsAll(C)); // true C는 A의 부분집합임.
         
        //A.addAll(B); // 합집합
        //A.retainAll(B); // 교집합
        //A.removeAll(B); // A-B
         
        
        /*- Iterator
        *     - CoolectionsFramework에 있는  값을 하나하나 꺼내서 반복하여 처리하도록 하는 데이터 타입
        *     - 메소드
        *         - hasNext()
        *             - Iterator 객체 에 값이 있으면 True 반환 
        *         - next()
        *             - Iterator 객체에 들어있는 값 중 하나를 리턴
        *             - 리턴한 값을 Iterator 객체에서 지움
        */
        Iterator hi = A.iterator(); // collectionsframework 객체.iterator() -> Iterator 데이터타입의 객체 리턴
        // Iterator 객체 - collectionsframework 객체와 동일한 값을 갖는 배열?
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }
 
}