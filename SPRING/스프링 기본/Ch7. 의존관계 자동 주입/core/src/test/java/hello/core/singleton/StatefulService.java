package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기에서 문제 발생 -> 상태 유지 필드의 값이 변할 수 있다.
    }

    public int getPrice() {
        return price;
    }

//    // 지역변수 사용으로 해당 문제 해결
//    public int order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        // this.price = price; // 여기에서 문제 발생 -> 상태 유지 필드의 값이 변할 수 있다.
//        return price;
//    }
}
