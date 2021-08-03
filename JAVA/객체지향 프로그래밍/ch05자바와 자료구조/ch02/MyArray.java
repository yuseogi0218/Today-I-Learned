package Chapter5.ch02;

import javax.swing.*;

public class MyArray {

    int[] intArr; // int array
    int count; // 개수

    public int ARRAY_SIZE;
    public static final int ERROR_NUM = -999999999;

    public MyArray() {
        count = 0;
        ARRAY_SIZE = 10;
        intArr = new int[ARRAY_SIZE];
    }

    public MyArray(int size) {
        count = 0;
        ARRAY_SIZE = size;
        intArr = new int[size];
    }

    // 마지막에 넣기
    public void addElement(int num) {
        if (count >= ARRAY_SIZE) {
            System.out.println("not enough memory");
            return;
        }
        intArr[count++] = num;
    }

    // 중간에 넣기
    public void insertElement(int position, int num) {

        int i;
        if (position < 0 || position > count) {
            System.out.println("error message");
            return;
        }

        if (count >= ARRAY_SIZE) {
            System.out.println("full");
            return;
        }

        // 맨 뒤에꺼부터 하나씩 뒤로 보내기
        // 이동의 수는 요소의 개수에 비례함.
        for (i = count - 1; i >= position; i--) {
            intArr[i + 1] = intArr[i];
        }

        intArr[position] = num;
        count++;
    }

    // 삭제
    public int removeElement(int position) {

        int ret = ERROR_NUM;

        if (isEmpty()) {
            System.out.println("Array is empty");
            return ret;
        }

        if (position < 0 || position > count - 1) {
            System.out.println("index error");
            return ret;
        }

        ret = intArr[position];

        for (int i = position; i < count - 1; i++) {
            intArr[i] = intArr[i + 1];
        }
        count--;
        return ret;
    }

    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void printAll() {
        if(count == 0){
            System.out.println("출력할 내용이 없습니다.");
            return;
        }

        for (int e : intArr) {
            System.out.print(e);
            System.out.print(",");
        }
        System.out.println();
    }

    public int getElement(int position)
    {
        if(position < 0 || position > count-1){
            System.out.println("검색 위치 오류. 현재 리스트의 개수는 " + count +"개 입니다.");
            return ERROR_NUM;
        }
        return intArr[position];
    }

    public void removeAll()
    {
        for(int i=0; i<count; i++){
            intArr[i] = 0;
        }
        count = 0;
    }
}
