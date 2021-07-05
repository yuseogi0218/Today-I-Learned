package org.opentutorials.javatutorials.accessmodifier;

class Calculator{
    private int left, right; // 접근제어자 private -> 사용자가 직접 값 변경 불가능
     
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    private int _sum(){
        return this.left+this.right; //접근 제어자 private -> 사용자에게 직접적인 제공 불필요 (내부적 작업)
    }
    public void sumDecoPlus(){
        System.out.println("++++"+_sum()+"++++"); // public -> 사용자에게 직접적인 제공
    }
    public void sumDecoMinus(){
        System.out.println("----"+_sum()+"----");
    }
    
}
  
public class CalculatorDemo {
    public static void main(String[] args) {        
        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        
        c1.sumDecoPlus();
        c1.sumDecoMinus();
    }
}