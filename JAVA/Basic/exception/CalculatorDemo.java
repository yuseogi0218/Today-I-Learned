package org.opentutorials.javatutorials.exception;



class Calculator{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    
    public void divide(){
    	try { //������ �߻��� ����Ǵ� ����
    		System.out.print("������� ");
            System.out.print(this.left/this.right);
            System.out.print(" �Դϴ�.");
    	} catch(Exception e /*���� Ŭ���� �ν��Ͻ� - ������ ���� ������ ����ִ� ��ü*/) {
    		System.out.println("������ �߻��߽��ϴ�." + e.getMessage()); 
    		//���ܰ� �߻����� �� ����Ǵ� ����
    		
    		System.out.println("\n\ne.getMessage()\n"+e.getMessage()); // ���� ���׿� ���� ���� ������ ��Ʈ
            System.out.println("\n\ne.toString()\n"+e.toString()); // ���� ���׿� ���� �� �� �ڼ��� ����
            System.out.println("\n\ne.printStackTrace()");
            e.printStackTrace(); // ���ڿ��� �ƴ�-���� ���� ����, ȭ�鿡 �������� ��� - ���� �ڼ��� ���� ����
            
    	}
    	System.out.println("Dived End"); // ���� �߻��� catch���� ������ ��� ���� �Ǹ� �̾ ���� ������ ���� �ȴ�.
    }
    
    //���� �����
    public void divide2() {
    	if (right == 0) {
    		throw new DivideException("0���� ���� �� �����ϴ�.");
    	}
    	System.out.println(this.left / this.right);
    	
    }
    
} 

class DivideException extends RuntimeException{ // extends Exception -> checked error �̱� ������ ó�� ����
	DivideException (){
		super();
	}
	DivideException(String message){
		super(message);
	}
	
}

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.setOprands(10, 0);
        c1.divide();
        
        try{
        	c1.divide2();
        } catch(DivideException e) {
        	System.out.println(e.getMessage());
        }
    }
}