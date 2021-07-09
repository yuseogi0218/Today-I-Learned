package Chapter2.ch15;

public class TakeTransTest {
    public static void main(String[] args) {
        Student studentE = new Student("Edward", 20000);
        Taxi taxiJ = new Taxi("잘 간다 운수택시");

        studentE.takeTaxi(taxiJ,10000);

        studentE.showStudentInfo();
        taxiJ.showTaxiInfo();
    }


}
