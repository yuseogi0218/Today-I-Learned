package org.opentutorials.javatutorials.reference;

class A{
    public int id;
    A(int id){
        this.id = id;
    }
}
public class ReferenceDemo1 {
 
    public static void runValue(){
        int a = 1; //기본형 -> 복제 발생 
        int b = a; // a = 1 
        b = 2;
        System.out.println("runValue, "+a); 
    }
     
    public static void runReference(){
        A a = new A(1); // 참조형 -> 객체의 위치값만 가지고 있다.
        A b = a; // a.id = 2
        b.id = 2;
        System.out.println("runReference, "+a.id);      
    }
 
    public static void main(String[] args) {
        runValue();
        runReference();
    }
 
}

// new 를 통해서 생성한 데이터 들은 참조형 데이터 타입 이다.
// 기본 데이터 타입 과 참조형 데이터 타입은 다르게 동작한다.

/*
 * 참조와 복제의 차이
 * - 참조
 *     - 바로가기
 *     - 원본 변경시 -> 바로가기(참조)에 영향 O
 *     - 적은양의 메모리 사용
 * - 복제
 *     - 복사
 *     - 원본 파일 내용 변경시 복사본 변경 X
 */