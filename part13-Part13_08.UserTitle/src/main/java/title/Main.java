package title;


import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What should be the title? ");
        String title = input.nextLine();

        //launching UI with title as parameter
        launch(UserTitle.class, "--title=" + title);

    }

}
