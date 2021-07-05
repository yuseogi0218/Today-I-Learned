package org.opentutorials.javatutorials.exception;
import java.io.*;

public class CheckedExceptionDemo {
    public static void main(String[] args) {
    	
        BufferedReader bReader = null;
		try {
			bReader = new BufferedReader(new FileReader("out.txt")); //FileNotFoundException -> API 가 던진 예외를 잡은것
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
        
		String input = null;
		try {
			input = bReader.readLine(); // IOException
		} catch (IOException e) {
			e.printStackTrace();
		} 
        System.out.println(input); 
    }
}