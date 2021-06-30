package org.opentutorials.javatutorials.exception;
//exception 만들기
class CalculatorException{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    public void divide(){
    	 if(this.right == 0){ //divide실행시, this.right==0이면 error 발생
             throw new ArithmeticException("0으로 나누는 것은 허용되지 않습니다."); //사용자정의로 예외를 만듦.
         }
    }
} 
public class CalculatorDemoException {
    public static void main(String[] args) {
        CalculatorException c1 = new CalculatorException();
        c1.setOprands(10, 0);
        try {
        	c1.divide();
        } catch(ArithmeticException e) {
        	System.out.println(e.getMessage());
        }
        
    }
}