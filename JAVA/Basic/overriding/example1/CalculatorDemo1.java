package org.opentutorials.javatutorials.overriding.example1;

class Calculator1 {
    int left, right;
 
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public int avg() {
        return ((this.left + this.right) / 2);
    }
}
 
class SubstractionableCalculator1 extends Calculator1 {
     
    public void sum() {
        System.out.println("���� ����� " +(this.left + this.right)+"�Դϴ�.");
    }
     
    public int avg() {
        return super.avg(); //overriding �� �ߺ��� ���� -> super = �θ�Ŭ����
        // + �߰� ���� ����
    }
     
    public void substract() {
        System.out.println(this.left - this.right);
    }
}
 
public class CalculatorDemo1 {
    public static void main(String[] args) {
        SubstractionableCalculator1 c1 = new SubstractionableCalculator1();
        c1.setOprands(10, 20);
        c1.sum();
        System.out.println("���� �����" + c1.avg());
        c1.substract();
    }
}
