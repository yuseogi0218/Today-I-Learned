package org.opentutorials.javatutorials.progenitor;

class Calculator{
    int left, right;
      
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    public void sum(){
        System.out.println(this.left+this.right);
    }
      
    public void avg(){
        System.out.println((this.left+this.right)/2);
    }

    public String toString(){ // toString은 객체를 문자로 표현하는 메소드이다. -> 상위 Object의 메소드 사용
    	// overriding을 통해서 toString() 재정의
        return "left : " + this.left + ", right : "+ this.right;
    }
    
}
  
public class CalculatorDemo {
      
    public static void main(String[] args) {
          
        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        System.out.println(c1);
        System.out.println(c1.toString());
    }
  
}