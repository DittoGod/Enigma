package com.enigma.rotor;

/**
 * Created by Simba Ndoro on 17/11/2016.
 *
 * @author simba_ndoro.
 */
public class Alphabet {
    private char[] alphabet;

    /**
     * Constructor for alphabet. Sets the characters in the alphabet.
     */
    public Alphabet() {
        String sAlphabet = " ";
        for (int i = 0; i < 256; i++) {
            if (((i > 32) && (i <= 126)) || ((i >= 161) && (i <= 255)) || ((i > 127) && (i < 131)) ||
                    (i == 128) || (i == 132)) {
                sAlphabet += (char) i;
            }
        }
        //NOTE: Had to add the last missing characters to the alphabet.
        sAlphabet += "\n\t\uF8FF";
        alphabet = sAlphabet.toCharArray();
    }

    /**
     * Getter for the alphabet.
     *
     * @return returns the char array alphabet.
     */
    public char[] getAlphabet() {
        return alphabet;
    }
}
