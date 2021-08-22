
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;
        int max = 100;
        int minimum = 0;


        while (true) {
            //System.out.print("> ");
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String [] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add") && amount > 0) {
                first = (first + amount) < max? first + amount : max;
            }

            if (command.equals("move") && amount > 0){
                if (amount > first){
                    amount = first;
                }

                first -= amount;
                second = (second + amount) < max? second + amount : max;
            }

            if (command.equals("remove") && amount > 0){
                second = (second - amount) > 0? second - amount : minimum;
            }

            System.out.println("");
        }
    }

}
