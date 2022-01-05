
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sumOfRows = new ArrayList<>();
        for (int row = 0; row < this.square.length; row++) {
            int sum = 0;
            //Goes through every column of the row and adds the value to the sum
            for (int column = 0; column < this.square[row].length; column++) {
                int value = this.square[row][column];
                sum += value;
            }
            //When done looping through a row, adds the sum to the arrayList
            sumOfRows.add(sum);
        }
        return sumOfRows;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sumOfColumns= new ArrayList<>();

        //Runs for a total of how many columns a row in the 2D-Array has
        for (int column = 0; column < this.square[0].length; column++) {
            int sumOfColumn = 0;
            //Goes through each row and adds the value of the index of column "x" to sum of column
            for (int row = 0; row < this.square.length; row++) {
                sumOfColumn += square[row][column];
            }
            //Adds the sum of the columns to the ArrayList
            sumOfColumns.add(sumOfColumn);
        }
        return sumOfColumns;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sumsOfDiagonals = new ArrayList<>();
        int sumTopLeftToBottomRight = 0;
        int sumBottomLeftToTopright = 0;

        for (int row = 0; row < square.length; row++) {
            //Each iteration add the value diagonally from top left to bottom right of square
            // square[row][row] 0,0 - 1,1 - 2,2
            sumTopLeftToBottomRight += square[row][row];
            //Each iteration add the value diagonally from bottom left to top right of square
            // square [row][(length - 1) - row]0,lastindex of row - 1,(lastindex of row-1) - 2,(lastindex of row-2)
            sumBottomLeftToTopright +=  square[row][(square.length - 1) - row];

        }

        sumsOfDiagonals.add(sumTopLeftToBottomRight);
        sumsOfDiagonals.add(sumBottomLeftToTopright);

        return sumsOfDiagonals;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
