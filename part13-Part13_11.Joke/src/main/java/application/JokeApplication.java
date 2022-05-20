package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {
    @Override
    public void start(Stage window) {
        // Creating main layout
        BorderPane layout = new BorderPane();

        // Creating menu for main layout
        HBox menu = new HBox();

        // Styling menu
        menu.setSpacing(10);
        menu.setPadding(new Insets(20, 20, 20, 20));

        // Creating components
        Button buttonQuestion = new Button("Joke");
        Button buttonAnswer = new Button("Answer");
        Button buttonExplanation = new Button("Explanation");

        // Adding components to menu
        menu.getChildren().addAll(buttonQuestion, buttonAnswer, buttonExplanation);

        // Adding and placing the menu at the top of the layout
        layout.setTop(menu);

        // Default joke
        String question = "What do you call a bear with no teeth?";
        String answer = "A gummy bear.";
        String explanation = "Because they have no teeth!";


        // Creating subview layout
        StackPane questionLayout = createView(question);
        StackPane answerLayout = createView(answer);
        StackPane explanationLayout = createView(explanation);

        // Adding events to buttons
        buttonQuestion.setOnAction((click) -> layout.setCenter(questionLayout));
        buttonAnswer.setOnAction((click) -> layout.setCenter(answerLayout));
        buttonExplanation.setOnAction((click) -> layout.setCenter(explanationLayout));

        // Creating the initial view
        layout.setCenter(questionLayout);

        // Creating scene with layout
        Scene scene = new Scene(layout);

        // Showing main scene
        window.setScene(scene);
        window.show();
    }


    // Method for creating views
    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));

        return layout;
    }
}
