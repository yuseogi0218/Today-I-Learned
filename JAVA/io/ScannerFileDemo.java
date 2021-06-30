package org.opentutorials.javatutorials.io;

import java.util.Scanner;
import java.io.*;

public class ScannerFileDemo {

	public static void main(String[] args) {
		try {
            File file = new File("out.txt");
            Scanner sc = new Scanner(file); //file���� �� ��ĵ
            while(sc.hasNextInt()) { // file���ǰ� ��ĵ�� ����-> true
                System.out.println(sc.nextInt()*1000); 
            }
            sc.close();
        } catch(FileNotFoundException e){//FileNotFoundException�� ������ ������
            e.printStackTrace();//���� e�� ȭ�鿡 ���
        }

	}

}
