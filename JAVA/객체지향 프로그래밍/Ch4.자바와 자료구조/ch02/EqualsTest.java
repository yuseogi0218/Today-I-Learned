package Chapter4.ch02;

public class EqualsTest  {
    public static void main(String[] args) throws CloneNotSupportedException {

        Student std1 = new Student(100, "Lee");
        Student std2 = new Student(100, "Lee");

        System.out.println(std1 == std2); // 물리적으로 다른 객체 이기 때문에 false 이다.
        // .equals 를 재 정의 하여 논리적으로 비교 가능하게 만든다.

        System.out.println(std1.equals(std2));

        // hashCode() 재정의 하여 두 인스턴스의 hashCode가 같게 함
        System.out.println(std1.hashCode());
        System.out.println(std2.hashCode());

        // 실제 hashCode 값
        System.out.println(System.identityHashCode(std1));
        System.out.println(System.identityHashCode(std2));

        // Clone()
        Student copyStudent = (Student) std1.clone();
        System.out.println(copyStudent);
    }
}
