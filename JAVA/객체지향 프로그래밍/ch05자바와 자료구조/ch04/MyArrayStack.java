package Chapter5.ch04;

import Chapter5.ch02.MyArray;

public class MyArrayStack {
    int top; // 맨 마지막 위치(top)에서만 자료를 추가, 삭제, 꺼내올 수 있음
    MyArray arrayStack;

    public MyArrayStack()
    {
        top = 0;
        arrayStack = new MyArray();
    }

    public MyArrayStack(int size)
    {
        top = 0;
        arrayStack = new MyArray(size);
    }

    public void push(int data)
    {
        if(isFull()){
            System.out.println("stack is full");
            return;
        }

        arrayStack.addElement(data);
        top++;
    }

    public int pop()
    {
        if (top == 0){
            System.out.println("stack is empty");
            return MyArray.ERROR_NUM;
        }
        return arrayStack.removeElement(--top);

    }

    public int peek()
    {
        if (top == 0){
            System.out.println("stack is empty");
            return MyArray.ERROR_NUM;
        }
        return arrayStack.getElement(top-1);
    }

    public int getSize()
    {
        return top;
    }

    public boolean isFull()
    {
        if(top == arrayStack.ARRAY_SIZE){
            System.out.println("stack is Full");
            return true;
        }
        else return false;
    }

    public boolean isEmpty()
    {
        if (top == 0){
            System.out.println("stack is Empty");
            return true;
        }
        else return false;
    }

    public void printAll()
    {
        arrayStack.printAll();
    }
}
