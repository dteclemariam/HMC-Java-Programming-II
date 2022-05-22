package application.ui;

import application.domain.Dictionary;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainView extends Application {
    private Dictionary dictionary;

    //From https://docs.oracle.com/javase/8/javafx/api/javafx/application/Application.html
    // Life-cycle of Application class
    //The entry point for JavaFX applications is the Application class. The JavaFX runtime does the following,
    // in order, whenever an application is launched:
    //Constructs an instance of the specified Application class
    //Calls the init() method
    //Calls the start(javafx.stage.Stage) method
    //Waits for the application to finish, which happens when either of the following occur:
    //the application calls Platform.exit()
    //the last window has been closed and the implicitExit attribute on Platform is true
    //Calls the stop() method
    @Override
    public void init() throws Exception{
        this.dictionary = new Dictionary();
    }
    public void start(Stage window){
        // Creating view, starting with "subviews"
        InputView inputView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        // Creating the canvas/general layout
        BorderPane layout = new BorderPane();

        // Creating the menu
        HBox menu = new HBox();

        // Adding style to menu
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // Creating components for the menu
        Button buttonNewEntries = new Button("Enter new words");
        Button buttonPracticeTranslations = new Button("Practice");

        // Adding components to menu
        menu.getChildren().addAll(buttonNewEntries, buttonPracticeTranslations);

        // Adding menu to canvas/general layout
        layout.setTop(menu);

        // Connecting the subviews to the buttons
        buttonNewEntries.setOnMouseClicked((click)->
                layout.setCenter(inputView.getView()));

        buttonPracticeTranslations.setOnMouseClicked(((click) ->
                layout.setCenter(practiceView.getView())));

        // Set the inputView as standard when the app starts
        layout.setCenter(inputView.getView());

        //Creating the main view and high level layout
        Scene scene = new Scene(layout, 400, 300);

        // Show view
        window.setScene(scene);
        window.show();


    }
}
