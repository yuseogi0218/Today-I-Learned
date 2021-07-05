package org.opentutorials.javatutorials.io;

import java.util.Scanner;
import java.io.*;

public class ScannerFileDemo {

	public static void main(String[] args) {
		try {
            File file = new File("out.txt");
            Scanner sc = new Scanner(file); //file안의 값 스캔
            while(sc.hasNextInt()) { // file안의값 스캔중 숫자-> true
                System.out.println(sc.nextInt()*1000); 
            }
            sc.close();
        } catch(FileNotFoundException e){//FileNotFoundException인 에러를 만날때
            e.printStackTrace();//에러 e를 화면에 출력
        }

	}

}
