package org.opentutorials.javatutorials.Inheritance.example3;

class Calculator5 {
    int left, right;
     
    /*public Calculator(int left, int right){
    	this.left = left;
        this.right = right;
    } -> ���� �߻� = �θ� Ŭ�������� �Ű������� �ִ� �����ڸ� �����ϸ�, ����Ŭ�������� �θ��� �⺻ �����ڸ� ȣ�� �� �� ����. ->  �⺻ �����ڸ� ��������� �����϶�� ���� �߻�
    */
    
    public Calculator5() {} //�ذ� -> �θ� Ŭ�������� �⺻ �����ڸ� ����
     
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}
 
class SubstractionableCalculator5 extends Calculator5 {// �θ� Ŭ������ Calculator �� �����ڸ� �ڵ����� ȣ�� 
    public SubstractionableCalculator5(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void substract() {
        System.out.println(this.left - this.right);
    }
}
 
public class CalculatorConstructorDemo5 {
    public static void main(String[] args) {
        SubstractionableCalculator5 c1 = new SubstractionableCalculator5(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}

//���� Ŭ������ ���� Ŭ������ �����ڵ��� �ϴ� ���� ���ٸ�-> ����Ŭ������ �����ڸ� ����Ŭ���� �����ڿ��� ȣ���Ѵٸ� -> �ذ� -> super()