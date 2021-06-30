package org.opentutorials.javatutorials.overriding.example1;

/*overriding - ������
 * �θ� ������ Ŭ���� �Ǵ� �޼ҵ带 �ڽ� Ŭ�������� ����� �Ͽ� �ڽ� Ŭ�������� ���������� ������
 * 
 * ���� - �޼ҵ��� ����(signature) ��ġ
 * - �޼ҵ��� �̸�
 * - �޼ҵ� �Ű������� ���ڿ� ������ Ÿ�� �׸��� ����
 * - �޼ҵ��� ���� Ÿ��
 */
class Calculator {
    int left, right;
 
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
 
class SubstractionableCalculator extends Calculator {
     
    public void sum() {
        System.out.println("���� ����� " +(this.left + this.right)+"�Դϴ�.");
    } // �θ�Ŭ������ sum() �޼ҵ带 overriding -> �޼ҵ� overriding 
     
    /*
     *  public int avg() {
        return (this.left + this.right)/2;
    } -> error -> �޼ҵ��� ���� Ÿ�� �� ��ġ -> ���� �� ����
     */
    
    public void substract() {
        System.out.println(this.left - this.right);
    }
}
 
public class CalculatorDemo {
    public static void main(String[] args) {
        SubstractionableCalculator c1 = new SubstractionableCalculator();
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}