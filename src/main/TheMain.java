package main;

import javafx.application.Application;
import javafx.stage.Stage;
import viewcontroller.Controller;

public class TheMain extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Controller.show(primaryStage);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}