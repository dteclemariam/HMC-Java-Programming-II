import java.util.Random;

public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        // implement the creation of a magic square with the Siamese method algorithm here
        addValues(square, size);
        return square;
    }

    private void addValues(MagicSquare square, int size){
        //helper variables
        int totalColumns = size * size;
        int filledColumns = 0;
        int currentValue = 5;
        int constantDifference = 5;

        //Starts with the central box of the first row
        int startingColumnIndex = size/2;
        int startingRowIndex = 0;


        //Places the first value
        int [] nextPositionRowColumn = {startingColumnIndex, startingRowIndex};
        square.placeValue(nextPositionRowColumn[0], nextPositionRowColumn[1], currentValue);

        //Runs while filled columns(with values) is smaller than total columns
        while (filledColumns < totalColumns){
            System.out.println(square);
            //gets next position
            nextPositionRowColumn = getNextPosition(nextPositionRowColumn, square);
            //adds value to new position
            currentValue += constantDifference;
            square.placeValue(nextPositionRowColumn[0], nextPositionRowColumn[1], currentValue);
            filledColumns++;
        }
    }

    private int [] getNextPosition(int [] currentPosition, MagicSquare square){
        //nextPosition where the first index (0) is row and the second[1] is column
        int [] nextPosition = new int [2];
        int indexOfColumn = currentPosition[0] + 1;
        int indexOfRow = currentPosition[1] - 1;


        //Runs as long as the method readValue of MagicSquare returns 0 (value has not been placed in column)
        //or returns -1 index if column or row is out of bound.
        // TODO: 05.01.2022 somehow overwrites if there is already a value there
        while (square.readValue(indexOfColumn, indexOfRow) < 0) {

            //Changes the index of the row to the bottom of the 2d array if it tries to access an index > 0
            if (indexOfRow < 0){
                indexOfRow = square.getHeight() - 1;
            }

            //Changes the index of the column to the most left (0) of the 2d array
            //if it tries to access an index the same length or greater than the width of the array
            if (indexOfColumn >= square.getWidth()){
                indexOfColumn = 0;
            }

            //If the column already has a value, move one column down
            if (square.readValue(indexOfColumn, indexOfRow) > 0){
                indexOfRow--;
            }

            if (square.readValue(indexOfColumn, indexOfRow) == 0){
                break;
            }

        }

        nextPosition[0] = indexOfColumn;
        nextPosition[1] = indexOfRow;
        return nextPosition;

    }

    //Return a random number between 1-100.
    private int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }



}
