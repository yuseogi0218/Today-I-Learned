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
        Person3 p1 = new Person3("����"); // �´� �Է°� - int, ������, ���ڿ��� �Է��ص� error�� �ȳ�Ÿ��.
        								// ��Ÿ�� error ��Ÿ�� ���� ��Ÿ�� -> Ÿ���� �������� �ʴ�.
        EmployeeInfo ei = (EmployeeInfo)p1.info; // p1�� info - object(����Ŭ����), EmployeeInfo - ����Ŭ���� 
        					// �� ��ȯ �ʿ�
        System.out.println(ei.rank);
    }
}

// �ذ� -> generic
// Ÿ���� �����ϴٴ� ������, �ڵ��� �ߺ��� �����ϴ� ���Ǽ� -> �ΰ��� ��� ������Ű�� ���� ���°�