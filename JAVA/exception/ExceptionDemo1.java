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
    		System.out.println("other Exception e"); // -> 제일 위로 올리면 경고 -> Exception 이 먼저 나타나있다.
    	} /* 다중 catch -> 여러 예외에 따라 경우를 나눔.
     	   *catch(Exception e){} -> else의 역할을 한다.*/
    	  finally {
    		// 예외여부와 관계없이 실행되는 로직
    		// 항상 try catch 뒤에 나와야 한다.
    		System.out.println("finally");
    		/* 사용 예시 - DataBase연결
    		 * 
    		 * try{ DB 제어} 
    		 *  	catch(){}
    		 *  	catch(){}
    		 *  	finally {DB연결 해체}
    		 */
    	}
        
    }
}
 
public class ExceptionDemo1 {
    public static void main(String[] args) {
        A a = new A();
        
        a.z(10, 1); //ArrayIndexOutOfBoundsException -> 배열에 존재하지 않는 인덱스 값 호출
        
        a.z(1, 0); //- 10/0 - ArithmeticException -> 정수를 0으로 나눔.
        
        a.z(2, 1); // error 없음 -> finally만 실행
        
    }
}