package viewcontroller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public static void show(Stage stage) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(Controller.class.getResource("view.fxml"));
        Parent root = loader.load();

        stage.setTitle("Color Calculator");
        stage.setScene(new Scene(root));
        stage.show();
    }
}