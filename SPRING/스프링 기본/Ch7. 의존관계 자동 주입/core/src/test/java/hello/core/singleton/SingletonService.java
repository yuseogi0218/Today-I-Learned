package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부에 instance 로 하나 가지고 있다.
    private static final SingletonService instance = new SingletonService();

    // 해당 서비스가 필요할 시
    public static SingletonService getInstance() {
        return instance;
    }

    // private 생성자
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글통 객체 로직 호출");
    }

}
