package buttonandlabel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage window){
        //components
        Button buttonComponent = new Button("Button");
        Label labelComponent = new Label("Example text on label");

        //FlowPane for grouping components
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(labelComponent);

        //Adds the component group (FlowPane) to the view
        Scene view = new Scene(componentGroup);

        //Sets the Scene (view) to be shown on the Stage (window)
        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        //Launched from another class
        //launch(ButtonAndLabelApplication.class);
    }

}
