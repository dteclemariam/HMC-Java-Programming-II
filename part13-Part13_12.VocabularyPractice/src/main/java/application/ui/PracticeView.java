package application.ui;

import application.domain.Dictionary;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
    Dictionary dictionary;
    String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.getRandomWord();
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        // Creating components
        Label instructionsText = new Label("Translate the word '" + word + "'"); //With random word
        TextField translationField = new TextField();
        translationField.setPromptText("Write the translation here");
        Button buttonCheck = new Button("Check");
        Label feedbackText = new Label();

        // Adding styling to layout
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        // Adding components to layout
        layout.add(instructionsText, 0 , 0);
        layout.add(translationField, 0, 1);
        layout.add(buttonCheck, 0, 2);
        layout.add(feedbackText, 0 ,3);

        // Adding event handling
        buttonCheck.setOnMouseClicked((click) -> {
            String translation = translationField.getText();
            // Checks if the value of the word in the -hashMap equals the answer and changes label
            if (dictionary.getTranslation(word).equals(translation)) {
                feedbackText.setText("Correct!");
            // Changes the feedbackText if the answer is wrong and returns
            } else {
                feedbackText.setText("Incorrect! The translation fo the word '" + word + "' is '"
                        + dictionary.getTranslation(word) + "'.");
                return;
            }

            // Gets a new random word from arrayList, sets the instructionText and clears the translationField
            this.word = dictionary.getRandomWord();
            instructionsText.setText("Translate the word '" + this.word + "'");
            translationField.clear();
        });

        return layout;

    }

}

