package org.opentutorials.javatutorials.progenitor;
//.equals -> String ��
//equals�� ����Ҷ��� hash code�� �����Ͽ��� �Ѵ�.
class Student{
    String name;
    Student(String name){
        this.name = name;
    }
    public boolean equals(Object obj) { //�Ű����� Object obj
        Student _obj = (Student)obj; // s2�� name 
        // �θ�(object)�� �ڽ��� ������ Ÿ���� �� �� ������, �ڽ��� �θ��� ������ Ÿ���� �Ǵ� ���� �����ϰ� �Ϸ��� 
        // -> (�ڽ�)�θ� - (Student)obj �θ��� ���� �ڽ��� ���·� ������(�����) �� ��ȯ
        return name /*s1�� name*/ == _obj.name;
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