/**
 * Created by vitaly on 9/12/16.
 */
public class Main {
    public static void main(String[] args) {
        Person person =  new Person();
        person.setName("alex");
        run(person);
        System.out.println(person.getName());
    }

    private static void run(Person x) { //делается копия ссылки
        x.setName("Bob"); // меняется то, что по ссылку
//        x = new Person(); // меняется то, на что ссылкается копия
//        x.setName("BOb");
    }
}
