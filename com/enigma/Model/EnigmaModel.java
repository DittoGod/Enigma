package com.enigma.Model;

import com.enigma.cypher.Cypher;

/**
 * @author Simba Ndoro.
 */
public class EnigmaModel {
    private Chooser choice = new Chooser();
    private Cypher cy = new Cypher();

    /**
     * Method to encrypt a line of text given the starting positions of the rotors.
     *
     * @param rotorA takes in an integer that will be the starting position of the first rotor.
     * @param rotorB takes in an integer that will be the starting position of the second rotor.
     * @param rotorC takes in an integer that will be the starting position of the third rotor.
     * @param text   takes in the string of text that will be encrypted.
     * @return will return the encrypted text.
     */
    public String encrypt(int rotorA, int rotorB, int rotorC, String text) {
        cy = new Cypher();
        cy.setRotors(rotorA, rotorB, rotorC);
        return cy.cypher(text, "encrypt");
    }

    /**
     * Method to encrypt a file given the starting positions of the rotors.
     *
     * @param rotorA the starting position of the first rotor.
     * @param rotorB the starting position of the second rotor.
     * @param rotorC the starting position of the third rotor.
     */
    public void encrypt(int rotorA, int rotorB, int rotorC) {
        String file = choice.selectFile();
        cy = new Cypher();
        cy.setRotors(rotorA, rotorB, rotorC);
        if (file != null) {
            String cypherText = cy.cypher(file, "encrypt");
            choice.saveFile(cypherText);
        }
    }

    /**
     * Method to decrypt a string given the starting positions of the rotors.
     *
     * @param rotorA takes in an integer that will be the starting position of the first rotor.
     * @param rotorB takes in an integer that will be the starting position of the second rotor.
     * @param rotorC takes in an integer that will be the starting position of the third rotor.
     * @param text   takes in the text that will be decrypted.
     * @return will return the decrypted text.
     */
    public String decrypt(int rotorA, int rotorB, int rotorC, String text) {
        cy = new Cypher();
        cy.setRotors(rotorA, rotorB, rotorC);
        return cy.cypher(text, "decrypt");
    }

    /**
     * Method to decrypt a file given the starting rotation of the rotors.
     *
     * @param rotorA takes in an integer that will be used to set the starting position for the first rotor.
     * @param rotorB takes in an integer that will be used to set the starting position for the second rotor.
     * @param rotorC takes in an integer that will be used to set the starting position for the third rotor.
     */
    public void decrypt(int rotorA, int rotorB, int rotorC) {
        String file = choice.selectFile();
        cy = new Cypher();
        cy.setRotors(rotorA, rotorB, rotorC);
        if (file != null) {
            String text = cy.cypher(file, "decrypt");
            choice.saveFile(text);
        }
    }

    /**
     * Method to get the size of the rotor.
     *
     * @return will return an integer of the rotor size.
     */
    public int rotorSize() {
        return cy.getRotorSize();
    }

}
