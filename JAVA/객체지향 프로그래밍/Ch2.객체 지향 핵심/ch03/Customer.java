package Chapter3.ch03;

public class Customer {

    protected int customerID;
    protected String customerName;
    protected String customerGrade;

    // default 시 외부 패키지에서 접근 불가능
    int bonusPoint;
    double bonusRatio;

//    public Customer() {
//        customerGrade = "SILVER";
//        bonusRatio = 0.01;
//
//        System.out.println("Customer 호출");
//    }

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;

        customerGrade = "SILVER";
        bonusRatio = 0.01;
    }
    //--> 하위 클래스에서 오류 생김 -- 자동으로 상위 클래스 생성자를 만들기 때문 --> 매개변수로 전달할 값 없음

    public int calcPrice(int price) {

        bonusPoint += price * bonusRatio;
        return price;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public String showCustomerInfo() {
        return customerName + "님의 등급은 " + customerGrade + "이면, 보너스 포인트는 " + bonusPoint + "입니다.";
    }
}
