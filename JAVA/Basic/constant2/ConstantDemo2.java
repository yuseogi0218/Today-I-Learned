package org.opentutorials.javatutorials.constant2;

public class ConstantDemo2 { // ���ӽ����̽� - ���λ縦 ����.
	private final static int FRUIT_APPLE = 1;
    private final static int FRUIT_PEACH = 2;
    private final static int FRUIT_BANANA = 3;
    
    private final static int COMPANY_GOOGLE = 1;
    private final static int COMPANY_APPLE = 2; // �ι� ������.
    private final static int COMPANY_ORACLE = 3;
    
    public static void main(String[] args) {
        int type = FRUIT_APPLE; // APPLE - ���
        switch(type){
            case FRUIT_APPLE:
                System.out.println(57+" kcal");
                break;
            case FRUIT_PEACH:
                System.out.println(34+" kcal");
                break;
            case FRUIT_BANANA:
                System.out.println(93+" kcal");
                break;
        }
    }
}