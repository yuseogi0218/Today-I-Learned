package Chapter4.ch04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class c1 = Class.forName("Chapter4.ch04.Person");

        Person person = (Person) c1.newInstance();
        person.setName("Lee");
        System.out.println(person);

        Class c2 = person.getClass();
        Person p = (Person) c2.newInstance();
        System.out.println(p);


        //Person kim = new Person("Kim") 과 동일

        Class[] parameterTypes = {String.class};
        Constructor cons = c2.getConstructor(parameterTypes);

        Object[] initArgs = {"kim"};
        Person KimPerson = (Person) cons.newInstance(initArgs);
        System.out.println(KimPerson);
    }
}
