package Chapter2.ch06;

public class StudentTest {

    public static void main(String[] args) {

        Student studentKim = new Student();
        studentKim.studentName = "Kim";
        System.out.println(studentKim.showStudentInfo());

        Student studentLee = new Student(17102063, "Lee",3);

        System.out.println(studentLee.showStudentInfo());

    }
}
