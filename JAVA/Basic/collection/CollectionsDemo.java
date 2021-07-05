package org.opentutorials.javatutorials.collection;
/*
 * 정렬
 * collections.sort(리스트)
 * - 리스트 형식만 정렬해 준다.
 * - 리스트 내의 값은 Comparable을 구현하고있어야 한다.
 *     - 리스트 내의 값은 비교가능하여야 한다.
 */
import java.util.*;

class Computer implements Comparable{ // 정렬하기 위해 Comparable 구현 -> compareTo() 메소드를 구현하도록 강제
    int serial;
    String owner;
    Computer(int serial, String owner){
        this.serial = serial;
        this.owner = owner;
    }
    
    public int compareTo(Object o) { // compareTo(Object 비교하려는 객체)
        return this.serial - ((Computer)o).serial; //return 현재 객체.값 - ((현재 객체의 데이터 타입으로 형 변환)비교하려는 객체).값
    }
    
    public String toString(){
        return serial+" "+owner;
    }
}
 
public class CollectionsDemo {
     
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<Computer>(); // ArrayList
        computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(3233, "graphittie"));
        Iterator i = computers.iterator();
        
        System.out.println("before");
        while(i.hasNext()){
            System.out.println(i.next()); // 정렬 전 출력
        }
        
        // 정렬
        Collections.sort(computers); //collections클래스 - 데이터와관련된 작업들을 처리할수 있는 메소드, static
        // sort(리스트 데이터 타입) -> 정렬된 리스트 반환
        
        //정렬 후 출력
        System.out.println("\nafter");
        i = computers.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
 
}