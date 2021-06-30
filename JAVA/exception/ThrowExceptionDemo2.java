package org.opentutorials.javatutorials.exception;
import java.io.IOException;

class H{
	void throwArithmeticException() {
		throw new ArithmeticException();
	} // error ó�� ���ʿ�
	
	//error ó���� �ΰ��� ��� - try~catch / throws
	void throwIOException1() {
		try{throw new IOException();
		// error ó�� ���� 
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
 * checked ����
 * 	- RuntimeException�� ������ Exception�� ���� Ŭ����
 *  - �ݵ�� ó���ؾ� �ϴ� ����
 *  - �θ�Ŭ������ RuntimeException�� ������ �ȵ�.
 *  - error��Ȳ�� �����Ҷ� ������ ���� �� - ����ڰ� ���� ������ error
 *  
 * unchecked ����
 * 	- RuntimeException�� ���� Ŭ����
 *  - ó�� �ص� �ǰ�, ���ص� �Ǵ� ����
 *  - �θ�Ŭ������ RuntimeException�� �־�� ��.
 *  - error��Ȳ�� ���Ͽ� �� �� �ִ°� ����, app�� �����Ű�°� �� ������
 */