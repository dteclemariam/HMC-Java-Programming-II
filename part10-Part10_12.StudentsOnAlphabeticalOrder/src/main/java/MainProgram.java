import java.util.ArrayList;
import java.util.List;

public class MainProgram {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student first = new Student("jamo");
        students.add(first);
        Student second = new Student("jamo1");
        students.add(second);
        Student third = new Student("Aaron");
        students.add(third);
        System.out.println(first.compareTo(second));
        System.out.println();

        students.stream()
                .sorted()
                .map(student -> student.getName())
                .forEach(name -> System.out.println(name));
    }
}
