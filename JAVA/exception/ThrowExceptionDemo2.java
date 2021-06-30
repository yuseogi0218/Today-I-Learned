package org.opentutorials.javatutorials.exception;
import java.io.IOException;

class H{
	void throwArithmeticException() {
		throw new ArithmeticException();
	} // error 처리 불필요
	
	//error 처리의 두가지 방법 - try~catch / throws
	void throwIOException1() {
		try{throw new IOException();
		// error 처리 강제 
		} catch(IOException e) {
			e.getMessage();
		}
	}
	
	void throwIOException2() throws IOException {
		throw new IOException();
	}
}

/*
 *
 * checked 예외
 * 	- RuntimeException을 제외한 Exception의 하위 클래스
 *  - 반드시 처리해야 하는 예외
 *  - 부모클래스중 RuntimeException이 있으면 안됨.
 *  - error상황을 개선할때 이익이 있을 때 - 사용자가 복구 가능한 error
 *  
 * unchecked 예외
 * 	- RuntimeException의 하위 클래스
 *  - 처리 해도 되고, 안해도 되는 예외
 *  - 부모클래스에 RuntimeException이 있어야 함.
 *  - error상황에 대하여 할 수 있는게 없고, app을 종료시키는게 더 낳을때
 */