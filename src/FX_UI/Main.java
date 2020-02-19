package FX_UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    /*Main class for JavaFX UI*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Sets primary stage
        Parent root = FXMLLoader.load(getClass().getResource("style.fxml"));
        primaryStage.setTitle("ESOL-SMS");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
