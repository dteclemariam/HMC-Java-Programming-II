import java.util.*;

public class UserInterface {
    private Scanner scanner;
    List<Book> books;

    public UserInterface(Scanner scanner){
        this.scanner = scanner;
        this.books = new ArrayList<>();
    }

    public void start(){
        while (true){
            System.out.print("Input the name of the book, empty stops: ");
            String input = scanner.nextLine();

            if (input.isEmpty()){
                System.out.println();
                break;
            }

            String name = input;
            System.out.print("Input the age recommendation: ");
            int ageRecommendation = Integer.parseInt(scanner.nextLine());

            books.add(new Book(name, ageRecommendation));

            System.out.println("");
        }

        System.out.println(books.size() + " books in total.");
        System.out.println("");
        System.out.println("Books:");

        Comparator<Book> comparator = Comparator
                .comparing(Book::getAgeRecommendation)
                        .thenComparing(Book::getName);

        Collections.sort(books, comparator);
        books.stream()
                .forEach(book -> System.out.println(book));
    }


}
