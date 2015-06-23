package it.ispw.psv.travelagency;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class LaptopApp extends Application {
 
	public static Person currentUser;
	
	@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));

        primaryStage.setTitle("Travel Agency 3rd Millennium - Sign in");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        /*Controller controller = loader.getController();
        controller.setupListener();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}