package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    public void start(Stage window){
        //Building first view
        BorderPane bp = new BorderPane();
        //bp components
        Label textComponentFirstView = new Label("First view!");
        Button buttonToSecondView = new Button("To the second view!");
        bp.setTop(textComponentFirstView);
        bp.setCenter(buttonToSecondView);
        //Creating first view
        Scene firstView = new Scene(bp);

        //Building second view
        VBox vBox = new VBox();
        Button buttonToThirdView = new Button("To the third view!");
        Label textComponentSecondView = new Label("Second view!");
        vBox.getChildren().addAll(buttonToThirdView, textComponentSecondView);
        //Creating second view
        Scene secondView = new Scene(vBox);

        //Building third view
        GridPane gridPane = new GridPane();
        Label textComponentThirdView = new Label("Third view!");
        Button buttonToFirstView = new Button("To the first view!");
        gridPane.add(textComponentThirdView, 0, 0);
        gridPane.add(buttonToFirstView, 1, 1);
        //Creating scene
        Scene thirdView = new Scene(gridPane);

        //Event handlers
        buttonToFirstView.setOnAction((click)->{
            window.setScene(firstView);
        });

        buttonToSecondView.setOnAction((click)->{
            window.setScene(secondView);
        });

        buttonToThirdView.setOnAction((click)->{
            window.setScene(thirdView);
        });

        window.setScene(firstView);
        window.show();

    }

}
