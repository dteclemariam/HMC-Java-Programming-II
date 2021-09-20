
import java.util.ArrayList;
import java.util.Collections;

public class MainProgram {

    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(new Human("Matti", 150_000));
        humans.add(new Human("Merja", 50_000_000));
        humans.add(new Human("Pertti", 80));

        System.out.println(humans);
        //with stream
        humans.stream()
                .sorted()
                .forEach(human -> System.out.println(human));

        /*
         * Uncomment the comment below when you have completed the compareTo-method.
         */
        Collections.sort(humans);
        System.out.println(humans);

    }
}
