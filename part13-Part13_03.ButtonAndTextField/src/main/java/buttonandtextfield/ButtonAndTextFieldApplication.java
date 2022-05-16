package buttonandtextfield;

import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {

    @Override
    public void start(Stage window){
            //Components
        Button buttonComponent = new Button("Button");
        TextField textFieldComponent = new TextField();
        //Add placeholder
        textFieldComponent.setPromptText("Placeholder text");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(textFieldComponent);

        Scene view = new Scene(componentGroup);
        window.setScene(view);
        window.show();

    }

}
