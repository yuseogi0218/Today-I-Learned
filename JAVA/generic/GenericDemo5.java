package org.opentutorials.javatutorials.generic;
/*
 * 복수의 제너릭
 * - <이름1, 이름2,...> -> 이름이 달라야 한다.
 *     - 중간에 ","로 구분한다.
 * 
 * 제너릭 특징
 * <데이터  타입> - 참조형 데이터 타입만 올 수 있다. - int 불가능
 *     - 기본 데이터 타입을 쓰기 위해서는 wrapper 클래스
 *         - 기본 데이터 타입을 마치 객체 인거처럼 만들 수 있는 객체들을 제공
 *         - 
 *         - int -> Integer, double -> Double, ... 
 */

/*
 * 제너릭은 생략 가능하다
 */

/*
 * 제너릭은 클래스뿐만 아니라 메소드 레벨에서도 사용할수 있다.
 */

class EmployeeInfo5{
    public int rank;
    EmployeeInfo5(int rank){ this.rank = rank; }
}
class Person5<T, S>{
    public T info;
    public S id;
    Person5(T info, S id){ 
        this.info = info; 
        this.id = id;
    }
    public <U> void printInfo(U info){
        System.out.println(info);
    }// 메소드 레벨에서 제너릭 사용
}


public class GenericDemo5 {
    public static void main(String[] args) {
    	EmployeeInfo e = new EmployeeInfo(1);
    	Integer i =new Integer(10);
    	Person5 p1 = new Person5(e, i); // 제너릭 생략 가능
        // = Person5<EmployeeInfo, Integer> p1 = new Person5<EmployeeInfo, Integer>(e, i);
    	
    	// 메소드 레벨에서의 제너릭 호출
    	// p1.<EmployeeInfo>printInfo(e);//<데이터 타입>메소드(); -> <데이터 타입> 생략 가능
    	p1.printInfo(e);
    }
}
