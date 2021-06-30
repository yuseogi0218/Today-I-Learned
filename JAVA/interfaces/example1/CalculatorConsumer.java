package org.opentutorials.javatutorials.interfaces.example1;

class CalculatorDummy implements Calculatable{ //인터페이스 구현
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
        
        // 개발자에게 인계후 -> 더미 삭제 , 인계받은 클래스 객체 생성
        //Calculator c = new Calculator();
        
        c.setOprands(10, 20, 30);
        System.out.println(c.sum()+c.avg());
    }
}