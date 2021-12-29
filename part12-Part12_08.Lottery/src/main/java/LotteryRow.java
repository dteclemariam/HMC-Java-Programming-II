
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        // the method containsNumber is probably useful
        for (int i = 0; i < 7; i++) {
            int number = getRandomNumber();
            //While number is a number already int numbers array
            while (containsNumber(number)){
                number = getRandomNumber();
            }
            numbers.add(number);
        }
    }

    //Method for returning random number
    private int getRandomNumber(){
        Random randomizer = new Random();
        //returns a random number between 0-39 + 1 aka 1-40
        return randomizer.nextInt(40) + 1;
    }

    public boolean containsNumber(int number) {
        // Check here whether the number is among the drawn numbers
        return numbers.contains(number);
    }
}

