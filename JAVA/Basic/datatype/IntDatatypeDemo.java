package org.opentutorials.javatutorials.datatype;

public class IntDatatypeDemo {

	public static void main(String[] args) {
		// 1byte = 8bit
		
		// byte : -128 ~ 127
		byte a;
		a = 127;
		
		//short : -32,768 ~ 32,767
		short b;
		b = 32767;
		
		// int : -2,147,483,648 ~ 2,147,483,647
		int c;
		c = 2147483647;
		
		// long : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
		
		//메모리
		//둘 다 똑같이 8byte의 메모리를 사용하게 된다. 데이터 타입이 같기 때문이다.
		long f = 2147483647;
		long g = 1;
		
		// 변수 d와 변수 e는 똑같은 수를 저장하고 있지만, 변수 e가 2배의 메모리를 사용한다. 
		int d = 2147483647;
		long e = 2147483647;
		
		//정수를 저장할 때는 int를 사용하면 된다. 
		//int 형을 처리 할 때 CPU의 처리속도가 빠르고, int는 충분히 큰 수를 표현할 수 있는 데이터 타입
		
		//실수를 사용할 때는 double을 사용하도록 하자.
		
		//

	}

}
