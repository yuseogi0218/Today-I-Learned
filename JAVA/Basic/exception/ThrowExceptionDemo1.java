package org.opentutorials.javatutorials.exception;

import java.io.*;

class D {
    void run() throws FileNotFoundException,IOException{ // error �� ���� ����ڿ��� ����.
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
        
        try { // D���� ���� error ó�� - try~catch
			d.run();
		} catch (FileNotFoundException e) {
			System.out.println("out.txt������ �ʿ��մϴ�."); 
			// FileNotFoundException �� IOException�� ��ӵǾ� �ֱ� ������ FileNotFoundException try~catch ���� ����
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