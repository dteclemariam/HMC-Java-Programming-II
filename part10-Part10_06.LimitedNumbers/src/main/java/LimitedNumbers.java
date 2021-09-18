
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        while(true){
            int input = Integer.valueOf(scanner.nextLine());
            if (input < 0){
                break;
            }
            numbers.add(input);
        }

        numbers.stream()
                .filter(numb -> numb <= 5)
                .filter(numb -> numb >= 1)
                .forEach(numb -> System.out.println(numb));

    }
}
