package org.opentutorials.javatutorials.collection;
/*
 * ����
 * collections.sort(����Ʈ)
 * - ����Ʈ ���ĸ� ������ �ش�.
 * - ����Ʈ ���� ���� Comparable�� �����ϰ��־�� �Ѵ�.
 *     - ����Ʈ ���� ���� �񱳰����Ͽ��� �Ѵ�.
 */
import java.util.*;

class Computer implements Comparable{ // �����ϱ� ���� Comparable ���� -> compareTo() �޼ҵ带 �����ϵ��� ����
    int serial;
    String owner;
    Computer(int serial, String owner){
        this.serial = serial;
        this.owner = owner;
    }
    
    public int compareTo(Object o) { // compareTo(Object ���Ϸ��� ��ü)
        return this.serial - ((Computer)o).serial; //return ���� ��ü.�� - ((���� ��ü�� ������ Ÿ������ �� ��ȯ)���Ϸ��� ��ü).��
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
            System.out.println(i.next()); // ���� �� ���
        }
        
        // ����
        Collections.sort(computers); //collectionsŬ���� - �����ͿͰ��õ� �۾����� ó���Ҽ� �ִ� �޼ҵ�, static
        // sort(����Ʈ ������ Ÿ��) -> ���ĵ� ����Ʈ ��ȯ
        
        //���� �� ���
        System.out.println("\nafter");
        i = computers.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
 
}