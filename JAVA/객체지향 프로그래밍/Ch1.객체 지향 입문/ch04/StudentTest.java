package Chapter2.ch04;

public class StudentTest {

    public static void main(String[] args) {
        // 인스턴스 생성 - 클래스 기반으로 생성된 객체
        Student studentLee = new Student(); // - 참조 변수

        studentLee.studentID = 12345;
        studentLee.setStudentName("Lee");
        studentLee.address = "서울 강남구";

        studentLee.showStudentInfo();

        Student studentKim = new Student();
        studentKim.studentID = 54321;
        studentKim.studentName = "Kim";
        studentKim.address = "경기도 성남시";

        studentKim.showStudentInfo();
    }
}
