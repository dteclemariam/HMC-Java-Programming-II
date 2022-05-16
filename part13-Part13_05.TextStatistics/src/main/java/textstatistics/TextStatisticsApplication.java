package textstatistics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application{
    public void start(Stage window){
        BorderPane bp = new BorderPane();

        //BP child components
        TextArea textArea = new TextArea();
        bp.setCenter(textArea);

        HBox hBox = new HBox(
                new Label("Letters: 0"),
                new Label("Words: 0"),
                new Label("The longest word is:"));

        //Added some padding for space between labels
        hBox.setSpacing(10);

        bp.setBottom(hBox);

        Scene view = new Scene(bp);

        window.setScene(view);
        window.show();

    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

}
