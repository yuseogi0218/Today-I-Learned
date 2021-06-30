package org.opentutorials.javatutorials.progenitor;
//.equals -> String 비교
//equals를 사용할때는 hash code도 구현하여야 한다.
class Student{
    String name;
    Student(String name){
        this.name = name;
    }
    public boolean equals(Object obj) { //매개변수 Object obj
        Student _obj = (Student)obj; // s2의 name 
        // 부모(object)가 자식의 데이터 타입이 될 수 있지만, 자식이 부모의 데이터 타입이 되는 것을 가능하게 하려면 
        // -> (자식)부모 - (Student)obj 부모의 형을 자식의 형태로 강제로(명시적) 형 변환
        return name /*s1의 name*/ == _obj.name;
    }
}
 
class EqualsDemo {
 
    public static void main(String[] args) {
        Student s1 = new Student("egoing");
        Student s2 = new Student("egoing");
        System.out.println(s1 == s2); 
        System.out.println(s1.equals(s2));
 
        
    }
    
    
    
 
}