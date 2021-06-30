package org.opentutorials.javatutorials.constant2;
// enum - 열거형 - 서로 연관된 "상수"들의 집합
/*
 * 효과
 * - 코드가 단순해 진다.
 * - 인스턴스 생성과 상속을 방지한다.
 * - 키워드 enum을 사용하기 때문에 구현의 의도가 열거임을 분명하게 나타낼 수 있다.
 */

/*class Fruit{
	public static final Fruit APPLE  = new Fruit();
	public static final Fruit PEACH  = new Fruit();
	public static final Fruit BANANA  = new Fruit();
}*/

enum Fruit1{ //-> class 
    APPLE, PEACH, BANANA;
}
enum Company1{
    GOOGLE, APPLE, ORACLE;
}
 
public class ConstantDemo5 {
     
    public static void main(String[] args) {
        Fruit1 type = Fruit1.APPLE;
        switch(type){ // switch문에서 사용할 수 있는 데이터 타입은 정해져 있다. - enum, String, ....
            case APPLE: // switch문에 전달한 데이터 타입을 알고 있기 때문에 상수만 적으면 된다.
                System.out.println(57+" kcal");
                break;
            case PEACH:
                System.out.println(34+" kcal");
                break;
            case BANANA:
                System.out.println(93+" kcal");
                break;
        }
    }
}