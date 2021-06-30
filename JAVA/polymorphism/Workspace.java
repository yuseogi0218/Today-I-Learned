package org.opentutorials.javatutorials.polymorphism;

interface father{}
interface mother{}
interface programmer{
    public void coding();
}
interface believer{}

class Steve implements father, programmer, believer{ // Steve Ŭ������ father, programmer, beliver ����
    public void coding(){
        System.out.println("fast");
    }
}

class Rachel implements mother, programmer{ // Rachel Ŭ������ mother, programmer ����
    public void coding(){
        System.out.println("elegance");
    }
}

public class Workspace{ //����
    public static void main(String[] args){
        programmer employee1 = new Steve(); // Steve�� employee1���� �ν��Ͻ�ȭ, ������Ÿ�� - programmer
        programmer employee2 = new Rachel(); // Rachel�� employee2�� �ν��Ͻ�ȭ, ������Ÿ�� - programmer
         // ���忡���� Steve,Rachel�� programming���� �ٸ� interface�� �𸥴�.
        
        employee1.coding();
        employee2.coding(); // ������ �޼ҵ� �̸�������, ����� ������ Ŭ����(Steve, Rachel)�� ���ؼ� �ٸ���. - ������
    }
}