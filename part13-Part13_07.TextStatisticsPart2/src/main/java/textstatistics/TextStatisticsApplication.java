package textstatistics;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatisticsApplication extends Application {
    public void start(Stage window) {
        BorderPane bp = new BorderPane();

        //BP child Layout Hbox for stacking horizontally
        HBox hBox = new HBox ();
        Label textComponentLetters = new Label("Letters: 0");
        Label textComponentWords = new Label("Words: 0");
        Label textComponentLongestWord = new Label("The longest word is: ");
        hBox.getChildren().addAll(textComponentLetters, textComponentWords, textComponentLongestWord);
        //Added some padding for space between labels
        hBox.setSpacing(10);

        //bp components
        TextArea textArea = new TextArea();
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            //Sets the text on the label and ads characters
            textComponentLetters.setText("Letters: " + characters);

            String [] parts = newValue.split(" ");
            int words = parts.length;
            //Sets the text on the label and ads words
            textComponentWords.setText("Words: " + words);

            //Sets the text on the label and ads the longest word
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            textComponentLongestWord.setText("The longest word is: " + longest);

        });
        bp.setCenter(textArea);

        //Todo change the value of the labels based on the index, eventlistener on the labes?


        bp.setBottom(hBox);

        Scene view = new Scene(bp);

        window.setScene(view);
        window.show();
    }


        public static void main (String[]args){
            System.out.println("Hello world!");
        }

}
