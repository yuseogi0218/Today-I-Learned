package org.opentutorials.javatutorials.overloading.example1;

// 클래스에 메소드 정의시 같은 이름이지만 서로 다른 매개변수 형식을 가진 여러 메소드를 정의할 수 있는 방법

class Calculator{
    int left, right;
    int third =0 ;
    
      
    public void setOprands(int left, int right){
        System.out.println("setOprands(int left, int right)");
        this.left = left;
        this.right = right;
    }
     
    public void setOprands(int left, int right, int third){
        System.out.println("setOprands(int left, int right, int third)");
        /*this.left = left;
         *this.right = right; // 위와 중복 
         */
        this.setOprands(left, right); //-> 중복 제거
        this.third = third;
    }
     
    public void sum(){
        System.out.println(this.left+this.right+this.third);
    }
      
    public void avg(){
        System.out.println((this.left+this.right+this.third)/3);
    }
}
  
public class CalculatorDemo {
      
    public static void main(String[] args) {
          
        Calculator c1 = new Calculator();
        c1.setOprands(10, 20); // -> setOprands(int left, int right)
        c1.sum();       
        c1.avg(); // (10+20) / 3 -> 10
        c1.setOprands(10, 20, 30); // -> setOprands(int left, int right, int third)
        c1.sum();       
        c1.avg();
         
    }
  
}