package application.ui;

import application.domain.Dictionary;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {
    private Dictionary dictionary;

    public InputView(Dictionary dictionary){
        this.dictionary = dictionary;
    }

    // This method returns a reference to a Parent type object.
    // Parent is a superclass to all the classes used for layouts.
    // Any layout class can be represented as a Parent object.
    public Parent getView(){
        GridPane layout = new GridPane();

        //Creating layout components
        Label wordInstructions = new Label("Word");
        TextField wordField = new TextField();
        wordField.setPromptText("Write a word");
        Label translationInstructions = new Label("Translation");
        TextField translationField = new TextField();
        translationField.setPromptText("Write the translation");
        Button buttonAddWordSet = new Button("Add the word pair");

        // Adding style to layout
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        // Adding components to layout
        layout.add(wordInstructions, 0, 0);
        layout.add(wordField,0, 1);
        layout.add(translationInstructions, 0, 2);
        layout.add(translationField, 0, 3);
        layout.add(buttonAddWordSet, 0, 4);

        buttonAddWordSet.setOnMouseClicked((click) -> {
            String word = wordField.getText();
            String translation = translationField.getText();

            // Adds the word and translation to the dictionary hashMap
            dictionary.addTranslation(word, translation);

            // Clearing textfields for new input
            wordField.clear();
            translationField.clear();
        });

        return layout;
    }
}
