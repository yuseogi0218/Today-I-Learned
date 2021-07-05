package org.opentutorials.javatutorials.progenitor;
// Clone - 복제

class Student1 implements Cloneable{ // 복제 가능한 객체라는 사실을 JVM에게 알려줘야 한다. - Cloneable interface를 구현
									// Student 클래스가 복제 가능한지 구분해주는 역할 - Cloneable의 본문은 아무것도 없음.
									// protected Object - 서로다른 패키지에서 호출 x, 서로다른 패키지 어도 상속은 가능
    String name;
    Student1(String name){
        this.name = name;
    }
    
    public Object clone() throws CloneNotSupportedException{
        return super.clone(); // clone 은 다른 패키지에 있는 protected 객체이기 때문에 불러와야 한다.
    }
}
 
class CloneDemo {
 
    public static void main(String[] args) {
        Student1 s1 = new Student1("egoing");
       
        try { //clone 하는 과정에서 생기는 error 처리 - 상위 클래스에서 위임받음
            Student1 s2 = (Student1)s1.clone();
            System.out.println(s1.name);
            System.out.println(s2.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
 
}