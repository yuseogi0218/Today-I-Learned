package org.opentutorials.javatutorials.exception;



class Calculator{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    
    public void divide(){
    	try { //예외의 발생이 예상되는 로직
    		System.out.print("계산결과는 ");
            System.out.print(this.left/this.right);
            System.out.print(" 입니다.");
    	} catch(Exception e /*예외 클래스 인스턴스 - 에러에 대한 정보를 담고있는 객체*/) {
    		System.out.println("오류가 발생했습니다." + e.getMessage()); 
    		//예외가 발생했을 떄 실행되는 로직
    		
    		System.out.println("\n\ne.getMessage()\n"+e.getMessage()); // 예외 사항에 대한 가장 간단한 힌트
            System.out.println("\n\ne.toString()\n"+e.toString()); // 예외 사항에 대한 좀 더 자세한 정보
            System.out.println("\n\ne.printStackTrace()");
            e.printStackTrace(); // 문자열이 아닌-리턴 값이 없음, 화면에 에러사항 출력 - 가장 자세한 예외 정보
            
    	}
    	System.out.println("Dived End"); // 예외 발생후 catch안의 구문이 모두 실행 되면 이어서 밖의 로직이 실행 된다.
    }
    
    //예외 만들기
    public void divide2() {
    	if (right == 0) {
    		throw new DivideException("0으로 나눌 수 없습니다.");
    	}
    	System.out.println(this.left / this.right);
    	
    }
    
} 

class DivideException extends RuntimeException{ // extends Exception -> checked error 이기 때문에 처리 강제
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