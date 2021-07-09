package Chapter2.ch12;

public class Person {

    String name;
    int age;

    public Person() {
        //System.out.println("this 이전에는 어떠한 statement 도 올 수 없음");
        this("no name", 0);
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public void showPerson(){
        System.out.println(name + " , " + age);
    }

    public Person getPerson() {
        return this;
    }
}
