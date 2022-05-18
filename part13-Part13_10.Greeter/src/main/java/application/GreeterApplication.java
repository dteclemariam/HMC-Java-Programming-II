package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {
    @Override
    public void start(Stage window){
        // Creating layout for first view
        GridPane gridPane = new GridPane();

        // Creating components for first view
        Label instructions = new Label("Enter your name to start");
        TextField input = new TextField();
        input.setPromptText("John Doe");
        Button buttonStart = new Button("Start");

        // Adding components
        gridPane.add(instructions,0, 0);
        gridPane.add(input, 0, 1);
        gridPane.add(buttonStart, 0 ,2);

        // Styling layout
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPrefSize(300, 180);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        // Creating first view
        Scene firstView = new Scene(gridPane);

        // Creating layout for second view
        StackPane stackPane = new StackPane();

        // Creating components for second view
        Label greeting = new Label();

        // Adding components to second layout
        stackPane.getChildren().add(greeting);

        // Styling second layout
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setPrefSize(300, 180);

        //Creating view
        Scene greetingView = new Scene(stackPane);

        // Adding an event handler to the login button.
        // The view is changed if a name is written.
        buttonStart.setOnAction((click) -> {
            //If name field is empty when you click start it doesn't do anything
            if (input.getText().trim().equals("")){
                return;
            }

            // Sets the text in the label and view to greetingView
            greeting.setText("Welcome " + input.getText() + "!");
            window.setScene(greetingView);
        });


        window.setScene(firstView);
        window.show();
    }


}
