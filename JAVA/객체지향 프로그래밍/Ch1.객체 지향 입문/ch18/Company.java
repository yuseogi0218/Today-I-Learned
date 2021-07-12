package Chapter2.ch18;

// singleton 패턴

public class Company {

    private static Company instance = new Company(); // 유일한 company 객체

    private Company() {} // 컴파이러는 생성자 제공 X

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }

        return instance;
    }
}
