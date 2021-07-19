package Chapter4.ch03;

public class StringTest {
    public static void main(String[] args) {

        String java = new String("java");
        String android = new String("android");

        System.out.println(System.identityHashCode(java));
        java = java.concat(android); // 기존 java 와 다른 address 에 부여 됨 --> 메모리가 낭비될 수 있음

        System.out.println(System.identityHashCode(java));
        System.out.println(java);
    }
}
