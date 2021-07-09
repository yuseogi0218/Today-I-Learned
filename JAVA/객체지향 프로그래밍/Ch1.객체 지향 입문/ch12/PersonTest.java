package Chapter2.ch12;

public class PersonTest {
    public static void main(String[] args) {

        Person person = new Person();

        person.showPerson();

        System.out.println(person);

        Person person2 = person.getPerson();
        System.out.println(person2);

    }
}
