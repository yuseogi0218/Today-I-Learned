package Chapter2.ch16;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee employeeLee = new Employee();
        employeeLee.setEmployeeName("이순신");

        System.out.println(Employee.getSerialNum()); // static 변수는 클래스 이름으로 직접 참조 가능 하다.

        Employee employeeKim = new Employee();
        employeeKim.setEmployeeName("김윤신");

        System.out.println(employeeLee.getEmployeeName() + "님의 사번은" + employeeLee.getEmployeeId());
        System.out.println(employeeKim.getEmployeeName() + "님의 사번은" + employeeKim.getEmployeeId());

    }
}
