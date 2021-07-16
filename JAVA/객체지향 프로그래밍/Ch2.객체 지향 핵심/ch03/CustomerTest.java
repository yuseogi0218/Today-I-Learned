package Chapter3.ch03;

public class CustomerTest {

    public static void main(String[] args) {
        Customer customerLee = new Customer(10010, "이순신");
        customerLee.bonusPoint = 1000;
        System.out.println(customerLee.showCustomerInfo());


        VIPCustomer customerKim = new VIPCustomer(10020, "김유신");
        customerKim.bonusPoint = 10000;
        System.out.println(customerKim.showCustomerInfo());

        // 형 변환
        Customer vc = new VIPCustomer(12345, "noname");
        // 상위_클래스 인스턴스_이름 = new 하위_클래스();

        // vc 는 customer 의 변수 및 메소드만 사용 가능하다.
    }
}
