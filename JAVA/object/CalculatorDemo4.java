package org.opentutorials.javatutorials.object;


	class Calculator{
		// Ŭ���� - ��ü - ���赵
	    int left, right;
	      
	    public void setOprands(int left, int right){
	        this.left = left;
	        // this.���� = ��ü�� ����.����
	        // = �ν��Ͻ� �̸�.����
	        this.right = right;
	    }
	      
	    public void sum(){
	        System.out.println(this.left+this.right);
	    }
	      
	    public void avg(){
	        System.out.println((this.left+this.right)/2);
	    }
	}
	  
	public class CalculatorDemo4 {
	      
	    public static void main(String[] args) {
	          
	        Calculator c1 = new Calculator(); 
	        // �ν��Ͻ� - ���赵�� ���� ������� ��ǰ
	        //calculator() - ��ü <=> Ŭ����
	        // ��ü ȣ�� -> �ν��Ͻ� ����
	        //������Ÿ�� �ν��Ͻ��̸� = new ��ü�̸�();
	        c1.setOprands(10, 20);
	        c1.sum();       
	        c1.avg();       
	        // ��ü �� �޼ҵ� ȣ��
	        // ��ü����.�޼ҵ�();
	          
	        Calculator c2 = new Calculator();
	        // �� �ٸ� �ν��Ͻ� ����
	        c2.setOprands(20, 40);
	        c2.sum();       
	        c2.avg();
	    }
}
