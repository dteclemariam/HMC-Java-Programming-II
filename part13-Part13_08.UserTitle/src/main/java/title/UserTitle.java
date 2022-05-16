package title;


import javafx.application.Application;
import javafx.stage.Stage;

public class UserTitle extends Application {
    public void start(Stage window){
        //Gets the parameter from the launch-method in Main
        //The getParameters method returns a [Parameters] type object
        //whose method getNamed can access a hash table containing key-value pairs.
        // The key-value pairs are given to the launch method in the form --key = value.
        Parameters parameters = getParameters();
        String title = parameters.getNamed().get("title");

        //Setting title on window based on parameter from launching-method in main
        window.setTitle(title);
        window.show();
    }



}
