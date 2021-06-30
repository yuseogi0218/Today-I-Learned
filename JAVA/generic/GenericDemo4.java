package org.opentutorials.javatutorials.generic;

class StudentInfo4{
    public int grade;
    StudentInfo4(int grade){ this.grade = grade; }
}
class EmployeeInfo4{
    public int rank;
    EmployeeInfo4(int rank){ this.rank = rank; }
}
class Person4<T>{
    public T info;
    Person4(T info){ this.info = info; }
}
public class GenericDemo4 {
    public static void main(String[] args) {
        Person4<EmployeeInfo4> p1 = new Person4<EmployeeInfo4>(new EmployeeInfo4(1));
        EmployeeInfo4 ei1 = p1.info;
        System.out.println(ei1.rank); // 성공
         
        Person4<String> p2 = new Person4<String>("부장");
        String ei2 = p2.info;
        // System.out.println(ei2.rank); // 컴파일 실패
    }
}