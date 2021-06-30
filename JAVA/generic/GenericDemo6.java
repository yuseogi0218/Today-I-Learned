package org.opentutorials.javatutorials.generic;
/*
 * 제너릭의 제한
 * <데이터 타입 extends 부모클래스 or interface>
 *     -> 제너릭 인스턴스화 할때 부모클래스 or interface의 자식 or 구현화 시킨 클래스 만 데이터 타입으로 지정 가능
 */
abstract class Info6{
    public abstract int getLevel();
}
class EmployeeInfo6 extends Info6{
    public int rank;
    EmployeeInfo6(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}
class Person6<T extends Info6>{ // 데이터 타입 T 를 Info6의 자식들로만 오게 하도록 제한
    public T info;
    Person6(T info){
    	this.info = info; 
    	info.getLevel(); // Info6를 상속받았기 때문에 가능?
    	}
}
public class GenericDemo6 {
    public static void main(String[] args) {
        Person6<EmployeeInfo6> p1 = new Person6<EmployeeInfo6>(new EmployeeInfo6(1)); //<EmployeeInfo6> 는 Info6의 자식이기 때문에 가능
        //Person6<String> p2 = new Person6<String>("부장"); // <String> 은 Info6의 자식이 아니기 때문에 error
    }
}