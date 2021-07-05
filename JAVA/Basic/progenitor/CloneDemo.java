package org.opentutorials.javatutorials.progenitor;
// Clone - ����

class Student1 implements Cloneable{ // ���� ������ ��ü��� ����� JVM���� �˷���� �Ѵ�. - Cloneable interface�� ����
									// Student Ŭ������ ���� �������� �������ִ� ���� - Cloneable�� ������ �ƹ��͵� ����.
									// protected Object - ���δٸ� ��Ű������ ȣ�� x, ���δٸ� ��Ű�� � ����� ����
    String name;
    Student1(String name){
        this.name = name;
    }
    
    public Object clone() throws CloneNotSupportedException{
        return super.clone(); // clone �� �ٸ� ��Ű���� �ִ� protected ��ü�̱� ������ �ҷ��;� �Ѵ�.
    }
}
 
class CloneDemo {
 
    public static void main(String[] args) {
        Student1 s1 = new Student1("egoing");
       
        try { //clone �ϴ� �������� ����� error ó�� - ���� Ŭ�������� ���ӹ���
            Student1 s2 = (Student1)s1.clone();
            System.out.println(s1.name);
            System.out.println(s2.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
 
}