package org.opentutorials.javatutorials.constant2;
// enum - ������ - ���� ������ "���"���� ����
/*
 * ȿ��
 * - �ڵ尡 �ܼ��� ����.
 * - �ν��Ͻ� ������ ����� �����Ѵ�.
 * - Ű���� enum�� ����ϱ� ������ ������ �ǵ��� �������� �и��ϰ� ��Ÿ�� �� �ִ�.
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
        switch(type){ // switch������ ����� �� �ִ� ������ Ÿ���� ������ �ִ�. - enum, String, ....
            case APPLE: // switch���� ������ ������ Ÿ���� �˰� �ֱ� ������ ����� ������ �ȴ�.
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