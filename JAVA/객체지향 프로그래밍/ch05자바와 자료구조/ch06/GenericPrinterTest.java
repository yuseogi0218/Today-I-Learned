package Chapter5.ch06;

public class GenericPrinterTest {
    public static void main(String[] args) {

        Powder powder = new Powder();

        // GenericPrinter<Powder> powderGenericPrinter = new GenericPrinter<Powder>();
        GenericPrinter<Powder> powderGenericPrinter = new GenericPrinter<>();
        powderGenericPrinter.setMaterial(powder);

        Powder p = powderGenericPrinter.getMaterial();
        System.out.println(powderGenericPrinter.toString());

    }
}
