package org.opentutorials.javatutorials.exception;

class A{
    private int[] arr = new int[3];
    A(){
        arr[0]=0;
        arr[1]=10;
        arr[2]=20;
    }
    public void z(int first, int second){
    	try {
    		System.out.println(arr[first] / arr[second]);
    	}catch(ArithmeticException e) {
    		System.out.println("ArithmeticException e");
    	} catch(ArrayIndexOutOfBoundsException e) {
    		System.out.println("ArrayIndexOutOdBoundException e");
    	} catch(Exception e) {
    		System.out.println("other Exception e"); // -> ���� ���� �ø��� ��� -> Exception �� ���� ��Ÿ���ִ�.
    	} /* ���� catch -> ���� ���ܿ� ���� ��츦 ����.
     	   *catch(Exception e){} -> else�� ������ �Ѵ�.*/
    	  finally {
    		// ���ܿ��ο� ������� ����Ǵ� ����
    		// �׻� try catch �ڿ� ���;� �Ѵ�.
    		System.out.println("finally");
    		/* ��� ���� - DataBase����
    		 * 
    		 * try{ DB ����} 
    		 *  	catch(){}
    		 *  	catch(){}
    		 *  	finally {DB���� ��ü}
    		 */
    	}
        
    }
}
 
public class ExceptionDemo1 {
    public static void main(String[] args) {
        A a = new A();
        
        a.z(10, 1); //ArrayIndexOutOfBoundsException -> �迭�� �������� �ʴ� �ε��� �� ȣ��
        
        a.z(1, 0); //- 10/0 - ArithmeticException -> ������ 0���� ����.
        
        a.z(2, 1); // error ���� -> finally�� ����
        
    }
}