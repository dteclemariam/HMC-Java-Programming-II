package notifier;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {
    public void start(Stage window){
        //Layout
        VBox vBox = new VBox();

        //Components
        TextField textField = new TextField();
        textField.setPromptText("Write text here!"); //Placeholder
        Label label = new Label();
        Button button = new Button("Update");
        //Can only use object declared before method definition
        //if the label objet was created after the method definition it wouldn't work/see the object
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Text in label equals text in textField
                label.setText(textField.getText());
            }
        });

        //Add components to layout
        vBox.getChildren().addAll(textField, button, label);

        Scene view = new Scene(vBox);
        window.setScene(view);
        window.show();

    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

}
