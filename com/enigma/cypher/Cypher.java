package com.enigma.cypher;

import com.enigma.rotor.Rotor;


/**
 * Created by Simba Ndoro on 20/10/2016.
 *
 * @author simba_ndoro.
 */
public class Cypher {
    private Rotor smallRotor = new Rotor();
    private Rotor mediumRotor = new Rotor();
    private Rotor largeRotor = new Rotor();

    /**
     * Method that starts the encryption on a char by char basis.
     *
     * @param text   The string of text to be encrypted.
     * @param choice The string stating whether you want to encrypt or decrypt.
     * @return will return a string of the encrypted text.
     */
    public String cypher(String text, String choice) {
        String cypherArray = "";

        for (int i = 0; i < text.length(); i++) {
            cypherArray += enigma(text.charAt(i), choice);
        }

        return cypherArray;
    }

    /**
     * Method to encrypt and decrypt the characters that are handed to it.
     *
     * @param ch     takes in a character.
     * @param choice takes in a string of 'encrypt' or 'decrypt' that will be used to decide whether to encrypt or
     *               decrypt.
     * @return returns randomized character, if character doesn't exist then it will return
     * the character that was inputted.
     */
    private char enigma(char ch, String choice) {
        char character = ch;

        switch (choice) {
            case "decrypt": //decrypt
                character = largeRotor.charAt(smallRotor.indexOf(ch));
                character = largeRotor.charAt(mediumRotor.indexOf(character));
                break;
            case "encrypt": //encrypt
                character = mediumRotor.charAt(largeRotor.indexOf(ch));
                character = smallRotor.charAt(largeRotor.indexOf(character));
                break;
            default:
                System.out.println("Invalid choice.");
        }

        smallRotor.turn();

        if (smallRotor.getTurn() % 27 == 0) {
            mediumRotor.turn();
        }

        return character;
    }

    /**
     * Setter for the rotors.
     *
     * @param r1 takes an integer that will be used to set the starting position for the first rotor.
     * @param r2 takes an integer that will be used to set the starting position for the second rotor.
     * @param r3 takes an integer that will be used to set the starting position for the third rotor.
     */
    public void setRotors(int r1, int r2, int r3) {
        smallRotor.setTurn(r1);
        mediumRotor.setTurn(r2);
        largeRotor.setTurn(r3);
    }

    /**
     * Getter for the first rotors position.
     *
     * @return returns the position of the rotor as a string.
     */
    public String getSmallRotorPosition() {
        return String.valueOf(smallRotor.getTurn());
    }

    /**
     * Getter for the second rotors position.
     *
     * @return returns the position of the rotor as a string.
     */
    public String getMediumRotorPosition() {
        return String.valueOf(smallRotor.getTurn());
    }

    /**
     * Getter for the third rotors position.
     *
     * @return returns the position of the rotor as a string.
     */
    public String getLargeRotorPosition() {
        return String.valueOf(largeRotor.getTurn());
    }

    /**
     * Getter for the rotor size.
     *
     * @return will return the size of the rotor as a string.
     */
    public int getRotorSize() {
        return new Rotor().getSize();
    }
}
