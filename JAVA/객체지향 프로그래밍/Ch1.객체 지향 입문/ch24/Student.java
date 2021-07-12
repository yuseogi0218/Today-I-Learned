package Chapter2.ch24;

import java.util.ArrayList;

public class Student {

    int studentID;
    String studentName;
    ArrayList<Subject> subjectList;

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.subjectList = new ArrayList<>();
    }

    public void addSubject(String subjectName, int subjectScore) {
        subjectList.add(new Subject(subjectName, subjectScore));
    }

    public void showStudentInfo() {
        int total = 0 ;
        for (Subject subject : subjectList) {
            System.out.println("학생 " + studentName + "의 " + subject.getSubjectName() + " 과목 성적은 " + subject.getSubjectScore() + "입니다.");
            total += subject.getSubjectScore();
        }

        System.out.println("학생 " + studentName + "의 총점은 " + total + "입니다.");
    }
}
