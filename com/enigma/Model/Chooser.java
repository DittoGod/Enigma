package com.enigma.Model;

/**
 * Created by Simba Ndoro on 07/11/2016.
 *
 * @author simba_ndoro.
 */

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Chooser {
    Stage stage = new Stage();
    private FileChooser chooser = new FileChooser();
    private FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TEXT FILES", "*.txt", "*.png");

    /**
     * Method that allows the user to select a file to work with.
     *
     * @return will return the file as a string.
     * @throws IOException if user doesn't select anything or the file is corrupt.
     */
    public String selectFile() {
        chooser.getExtensionFilters().add(filter);
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            String currentLine;
            String text = "";
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));//Creates the buffered reader with the file.
                while ((currentLine = br.readLine()) != null) {
                    text += currentLine + "\n";
                }
                StringBuilder sb = new StringBuilder(text);
                sb.deleteCharAt(sb.length() - 1);
                text = sb.toString();
            } catch (Exception e) {
                String warning = "You did not select a file or the file you selected is corrupt.";
                message(warning, AlertType.WARNING);
            }
            return text; //returns the file as a string.
        }
        return null;
    }

    /**
     * Method to save the new file. Allows the user to select where they would
     * like to save the file and the name of the file.
     *
     * @param fileToSave takes in the string file.
     */
    public void saveFile(String fileToSave) {
        File file = chooser.showSaveDialog(stage);
        if (file != null) {
            if (file.exists()) {
                file.delete();
            }
            Path path = Paths.get(file.getAbsolutePath());
            byte data[] = fileToSave.getBytes(); //turns the string into bytes.
            try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(path, CREATE, APPEND))) {
                out.write(data, 0, data.length); //writes the file.
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Method for generating Graphical messages.
     *
     * @param message   takes in a string that will be displayed to the user.
     * @param alertType takes an alert type to set the pop-ups alert type.
     */
    public void message(String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}