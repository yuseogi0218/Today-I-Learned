package org.opentutorials.javatutorials.classinstance;

class Calculator3{
	
	//Ŭ���� �޼��� ����
	//public static ...
    public static void sum(int left, int right){
        System.out.println(left+right);
    }
     
    public static void avg(int left, int right){
        System.out.println((left+right)/2);
    }
}
 
public class CalculatorDemo3 {
     
    public static void main(String[] args) {
    	//Ŭ���� �޼��� ȣ��
    	// -> Ŭ����.�޼��� �̸�
        Calculator3.sum(10, 20);
        Calculator3.avg(10, 20);
         
        Calculator3.sum(20, 40);
        Calculator3.avg(20, 40);
    }
 
}