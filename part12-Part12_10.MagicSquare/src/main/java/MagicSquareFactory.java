import java.util.Random;

public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare magicSquare = new MagicSquare(size);
        // implement the creation of a magic square with the Siamese method algorithm here

                //Starting positions
        //starting at the first row
        int currentRow = 0;
        //Starting at middle column
        int currentColumn = size / 2;
        //placing the first value in the first box
        magicSquare.placeValue(currentColumn,  currentRow, 1);

        for (int i = 2; i <= size * size; i++) {
            //Next row is row - 1
            int nextRow = currentRow - 1;

            //If row is out of magic square (out of index) we jump to the bottom edge
            if (nextRow < 0){
                nextRow = magicSquare.getHeight() - 1;
            }

            //If column is out of magic square (out of index) we jump to the left edge
            int nextColumn = currentColumn + 1;
            if (nextColumn >= magicSquare.getWidth()){
                nextColumn = 0;
            }

            //Checks if  value of next current column and value is empty
            //If not empty (0) jumps one row down on the square
            int currentBoxValue = magicSquare.readValue(nextColumn, nextRow);
            if (currentBoxValue != 0){
                nextRow = currentRow + 1;
                nextColumn = currentColumn;
            }

            //places value in the column-row and increments with number to add
            magicSquare.placeValue(nextColumn, nextRow, i);
            currentRow = nextRow;
            currentColumn = nextColumn;
        }

        return magicSquare;
    }





}
