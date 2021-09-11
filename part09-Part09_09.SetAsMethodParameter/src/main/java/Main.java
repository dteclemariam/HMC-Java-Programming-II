import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // You can test your method here
        Set<String> set = new HashSet<>();
        set.add("Test1");
        set.add("Test2");
        set.add("Test3");

    }

    // implement the method returnSize here, which returns
    // the number of elements in the set that it receives as a parameter.

    public static int returnSize(Set set){
        return set.size();
    }

}
