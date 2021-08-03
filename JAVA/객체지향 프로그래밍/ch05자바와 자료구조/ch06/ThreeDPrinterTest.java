package Chapter5.ch06;

public class ThreeDPrinterTest {

    public static void main(String[] args) {

        Powder powder = new Powder();
        ThreeDPrinter3 printer = new ThreeDPrinter3();

        printer.setMaterial(powder);

        // Object 를 Powder 형태로 변환 시켜 줘야 함.
        Powder p = (Powder) printer.getMaterial();
    }
}
