package org.opentutorials.javatutorials.collection;
/*
 * Map
 * - key : value 형태
 * - key
 *     - 중복 안됨
 *     - 중복된 값 입력시
 *         - 나중에 넣은 value로 값 업데이트
 * - value
 *     - 중복 가능
 */
import java.util.*;

public class MapDemo {
 
    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap<String, Integer>(); // <key 데이터 타입, value 데이터 타입>
        a.put("one", 1); // key:value 추가 - 객체.put(key,value)
        a.put("two", 2);
        a.put("three", 3);
        a.put("four", 4);
        a.put("four", 3);
        System.out.println(a.get("one")); // value 반환 - 객체.get(key) 
        System.out.println(a.get("two"));
        System.out.println(a.get("three"));
        System.out.println(a.get("four")); //3반환
         
        // 반복 처리방법
        iteratorUsingForEach(a);
        iteratorUsingIterator(a);
    }
     
    static void iteratorUsingForEach(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet(); // entrySet() - Map의 데이터를 담고 있는 Set을 반환
            //반환한 Set의 값이 사용할 데이터 타입은 Map.Entry
            //   - Map.Entry는 인터페이스인데 아래와 같은 API
            //       - getKey - key 반환	
            //       - getvalue - value 반환
        for (Map.Entry<String, Integer> entry : entries) { 
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
     
    static void iteratorUsingIterator(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator(); // entries는 set이기 때문에 Iterator로 구현
        while(i.hasNext()){
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
 
}