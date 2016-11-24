package com.enigma.view;

import com.enigma.Model.EnigmaModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by Simba Ndoro on 10/11/2016.
 *
 * @author simba_ndoro.
 */
public class EnigmaController implements Initializable {

    @FXML
    private RadioButton encryptText;

    @FXML
    private RadioButton decryptText;

    @FXML
    private RadioButton encryptFile;

    @FXML
    private RadioButton decryptFile;

    @FXML
    private ComboBox<Integer> rotorA = new ComboBox<>();

    @FXML
    private ComboBox<Integer> rotorB = new ComboBox<>();

    @FXML
    private ComboBox<Integer> rotorC = new ComboBox<>();

    @FXML
    private TextField input;

    @FXML
    private TextField output;

    @FXML
    private ToggleGroup radioGroup;

    private EnigmaModel model = new EnigmaModel();

    /**
     * Enter method for enigma.
     */
    @FXML
    private void enter() {
        if (radioGroup.getSelectedToggle() == encryptText) {
            output.setText(model.encrypt(rotorA.getValue(), rotorB.getValue(), rotorC.getValue(), input.getText()));
        }
        if (radioGroup.getSelectedToggle() == decryptText) {
            output.setText(model.decrypt(rotorA.getValue(), rotorB.getValue(), rotorC.getValue(), input.getText()));
        }
        if (radioGroup.getSelectedToggle() == encryptFile) {
            model.encrypt(rotorA.getValue(), rotorB.getValue(), rotorC.getValue());
        }
        if (radioGroup.getSelectedToggle() == decryptFile) {
            model.decrypt(rotorA.getValue(), rotorB.getValue(), rotorC.getValue());
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= model.rotorSize(); i++) {
            list.add(i);
        }

        setRotor(rotorA, list);
        setRotor(rotorB, list);
        setRotor(rotorC, list);
    }

    /**
     * Method to set up the rotor choice combo box by adding the choices to it.
     * @param rotor takes in an integer combo box.
     * @param list takes in an integer ArrayList.
     */
    private void setRotor(ComboBox<Integer> rotor, ArrayList<Integer> list){
        rotor.getItems().clear();
        rotor.getItems().addAll(list);
        rotor.getSelectionModel().select(new Random().nextInt(list.size()));
    }
}
