package viewcontroller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.ColorCode;
import model.Model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    Label lbl_colorView = new Label();

    @FXML
    TextField txtF_hexValue = new TextField();

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

    public void setExactValue(KeyEvent keyEvent)
    {
        TextField textField = (TextField) keyEvent.getSource();

        if(keyEvent.getCode().getCode() >= 48 && keyEvent.getCode().getCode() <= 57)
        {
            if(textField.getId().equals("txtF_rgbValueRed"))
            {
                Model.chanceColorViaAbsoluteValue(ColorCode.RED, Integer.parseInt(textField.getText()));
            }

            else if(textField.getId().equals("txtF_rgbValueGreen"))
            {
                Model.chanceColorViaAbsoluteValue(ColorCode.GREEN, Integer.parseInt(textField.getText()));
            }

            else if(textField.getId().equals("txtF_rgbValueBlue"))
            {
                Model.chanceColorViaAbsoluteValue(ColorCode.BLUE, Integer.parseInt(textField.getText()));
            }

            String hexValue = Model.getHex();

            txtF_hexValue.setText(hexValue);

            lbl_colorView.setStyle("-fx-background-color: " + hexValue + ";");
        }
        else
            {
                textField.clear();
            }
    }

    public void setIntervalValue(Event event)
    {
        Button btn = (Button) event.getSource();

        if(btn.getId().equals("btn_changeRed"))
        {
            Model.chanceColorViaRelativeValue(ColorCode.RED, btn.getText());
        }

        else if(btn.getId().equals("btn_changeGreen"))
        {
            Model.chanceColorViaRelativeValue(ColorCode.GREEN, btn.getText());
        }

        else if(btn.getId().equals("btn_changeBlue"))
        {
            Model.chanceColorViaRelativeValue(ColorCode.BLUE, btn.getText());
        }

        String hexValue = Model.getHex();

        txtF_hexValue.setText(hexValue);

        lbl_colorView.setStyle("-fx-background-color: " + hexValue + ";");
    }
}