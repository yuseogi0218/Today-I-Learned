package Chapter4.ch03;

public class StringBuilderTest {
    public static void main(String[] args) {
        String java = new String("java");
        String android = new String("android");

        StringBuilder buffer = new StringBuilder(java);
        System.out.println(System.identityHashCode(buffer));
        buffer.append(android);
        System.out.println(System.identityHashCode(buffer)); // 힙 메모리 주소 동일 --> 메모리 낭비 없음

        String test = buffer.toString();
        System.out.println(test);
    }
}
