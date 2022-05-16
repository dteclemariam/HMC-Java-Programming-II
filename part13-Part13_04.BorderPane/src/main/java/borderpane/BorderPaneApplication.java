package borderpane;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    @Override
    public void start(Stage window){

        BorderPane bp = new BorderPane();

        //Adding components
        bp.setTop(new Label("NORTH"));
        bp.setRight(new Label("EAST"));
        bp.setBottom(new Label("SOUTH"));

        Scene view = new Scene(bp);

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

}
