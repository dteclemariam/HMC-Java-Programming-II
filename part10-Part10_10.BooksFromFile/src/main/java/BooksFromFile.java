
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        List<Book> books = new ArrayList<>();
        String pathToFile = "books.txt";
        books = readBooks(pathToFile);
        books.stream()
                .forEach(book -> System.out.println(book));


    }

    public static List<Book> readBooks(String file) {
        // reading the "files.txt" file line by line
        List<Book> books = new ArrayList<>();
        try {
            // reading the "books.txt" file line by line
            Files.lines(Paths.get(file))
                    // splitting the row into parts on the "," character
                    .map(row -> row.split(","))
                    // deleting the split rows that have less than 4 parts
                    // (we want the rows to always contain name, publishing year,page count and author)
                    .filter(parts -> parts.length >= 4)
                    .map(parts -> new Book(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2])
                    , parts[3]))
                    .forEach(book -> books.add(book));
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return books;


    }

}
