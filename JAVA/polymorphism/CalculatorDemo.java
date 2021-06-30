package org.opentutorials.javatutorials.polymorphism;

abstract class Calculator{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    } 
    int _sum() {
        return this.left + this.right;
    }
    public abstract void sum();  
    public abstract void avg(); // abstract �̱� ������ ������ ����
    
    public void run(){ // sum(), avg()ȣ���ϴ� ��ü���� �޼ҵ�
        sum();
        avg();
    }
    
}
class CalculatorDecoPlus extends Calculator {
    public void sum(){
        System.out.println("+ sum :"+_sum());
    }
    public void avg(){
        System.out.println("+ avg :"+(this.left+this.right)/2);
    }
} 

class CalculatorDecoMinus extends Calculator {
    public void sum(){
        System.out.println("- sum :"+_sum());
    }
    public void avg(){
        System.out.println("- avg :"+(this.left+this.right)/2);
    }
} 
public class CalculatorDemo {
	public static void execute(Calculator cal) {
		System.out.println("���� ���");
		cal.run();
	}
	
    public static void main(String[] args) { 
        Calculator c1 = new CalculatorDecoPlus(); // -> �θ� Ŭ������ �ν��Ͻ�ȭ�� ��ü�� ������ Ÿ���̴�.
        c1.setOprands(10, 20);
        c1.run();
         
        Calculator c2 = new CalculatorDecoMinus();
        c2.setOprands(10, 20);
        c2.run();
     // c1�� c2�� ������ Ÿ���� ������, �� ��ü�� Ŭ������� run()�� sum(),age()�� ���� ������ �ֱ� ������ ���� �ٸ��� ����ȴ�.
        
        execute(c1);
        execute(c2); 
    // �������� ��� ���� -> �� ��ü ��� run�� �ϰ� �ֱ� ������ �̰��� �޼ҵ�ȭ ���Ѽ� �ߺ����� �������ش�.
        
    } 
    
   
}