package org.opentutorials.javatutorials.constant2;
// enum�� ��� Ŭ������. �׷��� ������ �����ڸ� ���� �� �ִ�. ����, ������ �޼ҵ� ���� ���� �� �ִ�.
// ���� - ����μ��� ��ɸ� �ƴ� ����� ��� ���� �����Ѵ� ���� ���� ���� �� �� �ְ��Ѵ�.
// �� ���� �ڵ�� 
// enum�� �ɹ� ��ü�� ���� �� �� �ִ� ��ɵ� �����Ѵ�. - �迭ó�� - values()


enum Fruit2{
    APPLE("red"), PEACH("pink"), BANANA("yellow");
	// �ʵ尪 �ο�
	private String color; 
	// �޼ҵ� ����
	public String getColor() {
		return this.color;
	}
    Fruit2(String color){ //������ ����
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
        
        for(Fruit2 f : Fruit2.values()){ // enum ��� ����
            System.out.println(f+", "+f.getColor());
        }
    }
}