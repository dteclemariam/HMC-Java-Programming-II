import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your test code here
        Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(ollie);
        System.out.println("Study credits " + ollie.credits());
        ollie.study();
        System.out.println("Study credits "+ ollie.credits());
    }

    public static void printPersons(ArrayList<Person> persons){
        for (Person person : persons) {
            System.out.println(person);
        }
    }

}
