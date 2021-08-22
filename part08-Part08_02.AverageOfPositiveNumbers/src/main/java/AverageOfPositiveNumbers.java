
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;


        while(true){
            int numb = Integer.valueOf(scanner.nextLine());

            if (numb == 0){
                break;
            }

            if (numb > 0){
                sum += numb;
                count++;
            }
        }

        if (sum == 0){
            System.out.println("Cannot calculate the average");
        }else {
            System.out.println((1.0 * sum) / count);
        }
    }
}
