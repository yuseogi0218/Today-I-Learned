package org.opentutorials.javatutorials.interfaces.example1;

class CalculatorDummy implements Calculatable{ //�������̽� ����
    public void setOprands(int first, int second, int third){
    }
    public int sum(){
        return 60;
    }
    public int avg(){
        return 20;
    }
}
public class CalculatorConsumer {
    public static void main(String[] args) {
        CalculatorDummy c = new CalculatorDummy();
        
        // �����ڿ��� �ΰ��� -> ���� ���� , �ΰ���� Ŭ���� ��ü ����
        //Calculator c = new Calculator();
        
        c.setOprands(10, 20, 30);
        System.out.println(c.sum()+c.avg());
    }
}