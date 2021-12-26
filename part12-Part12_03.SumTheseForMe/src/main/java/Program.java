
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here

    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest){
        int sum = 0;
        fromWhere = fromWhere < 0? 0 : fromWhere;
        toWhere = toWhere > array.length? array.length : toWhere;

        for (int i = fromWhere; i < toWhere; i++) {
            int number = array[i];
            if (number >= smallest && number <= largest) sum += number;
        }
        return sum;
    }

}
