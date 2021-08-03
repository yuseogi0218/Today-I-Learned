package Chapter5.ch07;

public class Powder extends Material{

    public String toString() {
        return "재료는 Powder 입니다.";
    }

    @Override
    public void doPrinting() {
        System.out.println("powder 재료로 출력합니다.");
    }
}
