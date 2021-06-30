package org.opentutorials.javatutorials.exception;
//exception �����
class CalculatorException{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    public void divide(){
    	 if(this.right == 0){ //divide�����, this.right==0�̸� error �߻�
             throw new ArithmeticException("0���� ������ ���� ������ �ʽ��ϴ�."); //��������Ƿ� ���ܸ� ����.
         }
    }
} 
public class CalculatorDemoException {
    public static void main(String[] args) {
        CalculatorException c1 = new CalculatorException();
        c1.setOprands(10, 0);
        try {
        	c1.divide();
        } catch(ArithmeticException e) {
        	System.out.println(e.getMessage());
        }
        
    }
}