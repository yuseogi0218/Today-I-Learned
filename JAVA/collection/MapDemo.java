package org.opentutorials.javatutorials.collection;
/*
 * Map
 * - key : value ����
 * - key
 *     - �ߺ� �ȵ�
 *     - �ߺ��� �� �Է½�
 *         - ���߿� ���� value�� �� ������Ʈ
 * - value
 *     - �ߺ� ����
 */
import java.util.*;

public class MapDemo {
 
    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap<String, Integer>(); // <key ������ Ÿ��, value ������ Ÿ��>
        a.put("one", 1); // key:value �߰� - ��ü.put(key,value)
        a.put("two", 2);
        a.put("three", 3);
        a.put("four", 4);
        a.put("four", 3);
        System.out.println(a.get("one")); // value ��ȯ - ��ü.get(key) 
        System.out.println(a.get("two"));
        System.out.println(a.get("three"));
        System.out.println(a.get("four")); //3��ȯ
         
        // �ݺ� ó�����
        iteratorUsingForEach(a);
        iteratorUsingIterator(a);
    }
     
    static void iteratorUsingForEach(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet(); // entrySet() - Map�� �����͸� ��� �ִ� Set�� ��ȯ
            //��ȯ�� Set�� ���� ����� ������ Ÿ���� Map.Entry
            //   - Map.Entry�� �������̽��ε� �Ʒ��� ���� API
            //       - getKey - key ��ȯ	
            //       - getvalue - value ��ȯ
        for (Map.Entry<String, Integer> entry : entries) { 
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
     
    static void iteratorUsingIterator(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator(); // entries�� set�̱� ������ Iterator�� ����
        while(i.hasNext()){
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
 
}