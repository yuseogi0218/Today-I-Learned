package org.opentutorials.javatutorials.overloading.example1;

// Ŭ������ �޼ҵ� ���ǽ� ���� �̸������� ���� �ٸ� �Ű����� ������ ���� ���� �޼ҵ带 ������ �� �ִ� ���

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
         *this.right = right; // ���� �ߺ� 
         */
        this.setOprands(left, right); //-> �ߺ� ����
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