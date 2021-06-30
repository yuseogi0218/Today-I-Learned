package org.opentutorials.javatutorials.generic;

class StudentInfo3{
    public int grade;
    StudentInfo3(int grade){ this.grade = grade; }
}
class EmployeeInfo3{
    public int rank;
    EmployeeInfo3(int rank){ this.rank = rank; }
}
class Person3{
    public Object info;
    Person3(Object info){ this.info = info; }
}
public class GenericDemo3 {
    public static void main(String[] args) {
        Person3 p1 = new Person3("부장"); // 맞는 입력값 - int, 하지만, 문자열을 입력해도 error가 안나타남.
        								// 런타임 error 런타임 도중 나타남 -> 타입이 안전하지 않다.
        EmployeeInfo ei = (EmployeeInfo)p1.info; // p1의 info - object(상위클래스), EmployeeInfo - 하위클래스 
        					// 형 변환 필요
        System.out.println(ei.rank);
    }
}

// 해결 -> generic
// 타입이 안전하다는 장점과, 코드의 중복을 제거하는 편의성 -> 두개를 모두 만족시키기 위해 나온것