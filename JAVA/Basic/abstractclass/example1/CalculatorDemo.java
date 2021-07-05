package org.opentutorials.javatutorials.abstractclass.example1;

abstract class Calculator{ //���� �޼ҵ�� ���Ͽ� -> Ŭ���� -> �߻�
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    } 
    
    int _sum() {
    	return this.left+ this.right;
    }
    int _avg() {
    	return (this.left+this.right)/2;
    }
    
    public abstract void sum();  
    public abstract void avg(); //-> �߻� �޼ҵ� -> ����ڰ� �ۼ�
    
    public void run(){ //�հ� ��� ������ ����
        sum();
        avg();
    }
}


class CalculatorDecoPlus extends Calculator { //�߻� Ŭ���� ���
    public void sum(){
        System.out.println("+ sum :"+_sum()); // �߻� �޼ҵ� ���
    }
    public void avg(){
        System.out.println("+ avg :"+_avg());
    }
} 
class CalculatorDecoMinus extends Calculator {
    public void sum(){
        System.out.println("- sum :"+_sum());
    }
    public void avg(){
        System.out.println("- avg :"+_avg());
    }
} 


public class CalculatorDemo {
    public static void main(String[] args) { 
        CalculatorDecoPlus c1 = new CalculatorDecoPlus();
        c1.setOprands(10, 20);
        c1.run();
         
        CalculatorDecoMinus c2 = new CalculatorDecoMinus();
        c2.setOprands(10, 20);
        c2.run();
    }
   
}