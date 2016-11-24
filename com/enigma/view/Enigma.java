package com.enigma.view;
/**
 * Created by Simba Ndoro on 10/11/2016.
 *
 * @author simba_ndoro.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Enigma extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EnigmaView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Enigma Machine");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
