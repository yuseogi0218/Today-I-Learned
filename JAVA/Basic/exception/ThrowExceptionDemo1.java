package org.opentutorials.javatutorials.exception;

import java.io.*;

class D {
    void run() throws FileNotFoundException,IOException{ // error 를 다음 사용자에게 던짐.
        BufferedReader bReader = null;
        String input = null;
        bReader = new BufferedReader(new FileReader("out.txt"));
        input = bReader.readLine();      
        System.out.println(input); 
    }
}
class E{
    void run() {
        D d = new D();
        
        try { // D에서 던진 error 처리 - try~catch
			d.run();
		} catch (FileNotFoundException e) {
			System.out.println("out.txt파일이 필요합니다."); 
			// FileNotFoundException 은 IOException에 상속되어 있기 때문에 FileNotFoundException try~catch 생략 가능
		} catch (IOException e){
			e.printStackTrace();
		}
    }
}
public class ThrowExceptionDemo1 {
    public static void main(String[] args) {
         E e = new E();
         e.run();
    }   
}