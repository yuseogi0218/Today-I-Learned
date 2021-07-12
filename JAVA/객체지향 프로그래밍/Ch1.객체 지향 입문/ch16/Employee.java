package Chapter2.ch16;

public class Employee {

    private static int serialNum = 1000; //기준이 되는 변수

    private int employeeId;
    private String employeeName;
    private String department;

    public Employee() {
        serialNum++;
        employeeId = serialNum;
    }

    public static int getSerialNum() { // static 메서드

        int i = 0; // 지역변수여서 상관 없음.

        // employeeName = "Lee"; static 변수 내에서 instance 변수 사용 불가능

        return serialNum; // static 변수
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
