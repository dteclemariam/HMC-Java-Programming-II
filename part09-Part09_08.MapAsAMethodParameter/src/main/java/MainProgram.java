import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainProgram {

    public static void main(String[] args) {
        // test your method here
        Map<String, String> map = new HashMap<>();
        map.put("Test1", "Test1");
        map.put("Test2", "Test2");
        map.put("Test3", "Test3");
        System.out.println("Size of map: " + returnSize(map));

    }

    // Implement here a method returnSize, which takes a Map-object as a parameter 
    // and returns the size of the map object

    public static int returnSize(Map map){
        return map.size();
    }
}
