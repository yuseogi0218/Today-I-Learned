package org.opentutorials.javatutorials.collection;
/*
 * collectionsframework
 * - 배열의 불편한 점 해결
 *     - 배열은 한번 선언하면 그 크기를변경할 수 없다는 점
 * - 구성요소
 *     - Collection
 *         - Set
 *             - 중복되면 안된다.
 *         - List
 *             - 중복 가능 
 *             - ArrayList
 *         - Queue
 *     - Map
 *         - key : value 형태의 저장 공간
 *         
 * 
 */
import java.util.ArrayList;

public class ArrayListDemo {
 
    public static void main(String[] args) {
        String[] arrayObj = new String[2];
        arrayObj[0] = "one";
        arrayObj[1] = "two";
        // arrayObj[2] = "three"; 오류가 발생한다. -> 크기를 벗어남.
        for(int i=0; i<arrayObj.length; i++){
            System.out.println(arrayObj[i]);
        }
         
        /*
         * ArrayList
         * - 배열과는 다르게 생성시 크기 지정 X
         */
        ArrayList al = new ArrayList(); // 선언 - ArrayList 객체 이름 = new ArrayList();
        al.add("one"); // 값 추가 -> 어떠한 데이터의 타입도 수용 가능 -> 데이터 타입 - Object
        al.add("two");
        al.add("three");
        for(int i=0; i<al.size(); i++){ // ArrayList 크기 = 객체 이름.size();
        	Object value = al.get(i);// 인덱스 i 값 반환 - al.get(i) -> 데이터 타입 - Object
        	//or
        	String value_str = (String)al.get(i);
            System.out.println(value); 
            
        }
        // or generic 활용
        ArrayList<String> al2 = new ArrayList<String>(); 
        al2.add("one"); 
        al2.add("two");
        al2.add("three");
        for(int i=0; i<al.size(); i++){ 
        	String value2 = al2.get(i); // generic을 통해서 데이터 타입을 String 으로 지정 -> 형변환 필요 X
        	System.out.println(value2);
        }
    }
 
}