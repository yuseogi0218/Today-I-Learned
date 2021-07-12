package Chapter2.ch18;

import java.util.Calendar;

public class CompanyTest {

    public static void main(String[] args) {
        Company company1 = Company.getInstance(); // getInstance 는 static 메서드
        Company company2 = Company.getInstance();

        System.out.println(company1);
        System.out.println(company2);
        // company1 과 company2 는 같음

        //singleton 패턴
        Calendar calendar = Calendar.getInstance();

    }
}
