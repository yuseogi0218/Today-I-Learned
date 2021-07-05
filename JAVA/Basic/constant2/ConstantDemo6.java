package org.opentutorials.javatutorials.constant2;
// enum은 사실 클래스다. 그렇기 때문에 생성자를 가질 수 있다. 또한, 변수와 메소드 또한 가질 수 있다.
// 장점 - 상수로서의 기능만 아닌 상수가 어떠한 값을 갖게한느 등의 여러 일을 할 수 있게한다.
// 더 적은 코드로 
// enum은 맴버 전체를 열거 할 수 있는 기능도 제공한다. - 배열처럼 - values()


enum Fruit2{
    APPLE("red"), PEACH("pink"), BANANA("yellow");
	// 필드값 부여
	private String color; 
	// 메소드 생성
	public String getColor() {
		return this.color;
	}
    Fruit2(String color){ //생성장 만듦
        System.out.println("Call Constructor "+this);
        this.color = color;
    }
}
 
enum Company2{
    GOOGLE, APPLE, ORACLE;
}
 

public class ConstantDemo6 {
     
    public static void main(String[] args) {
        Fruit2 type = Fruit2.APPLE;
        System.out.println();
        switch(type){
            case APPLE:
                System.out.println(57+" kcal, color:" + Fruit2.APPLE.getColor());
                break;
            case PEACH:
                System.out.println(34+" kcal, color:" + Fruit2.PEACH.getColor());
                break;
            case BANANA:
                System.out.println(93+" kcal, color:" + Fruit2.BANANA.getColor());
                break;
        }
        
        for(Fruit2 f : Fruit2.values()){ // enum 멤버 열거
            System.out.println(f+", "+f.getColor());
        }
    }
}