package org.opentutorials.javatutorials.constant2;

public class ConstantDemo1 {
    private final static int APPLE = 1;
    private final static int PEACH = 2;
    private final static int BANANA = 3;
    
    public static void main(String[] args) {
        int type = APPLE; // APPLE - »ó¼ö
        switch(type){
            case APPLE:
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