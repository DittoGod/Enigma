package com.enigma.rotor;

/**
 * @author Simba Ndoro.
 */
public class Rotor {
    private char[] rotor;
    private int alphabetLength;
    private int turn = 0;
    private char[] defaultRotor;

    /**
     * constructor for the rotor.
     */
    public Rotor() {
        this.turn = 0;
        this.rotor = new Alphabet().getAlphabet();
        this.alphabetLength = rotor.length;
        this.defaultRotor = this.rotor;
    }

    /**
     * Method to find the location of the desired character.
     *
     * @param character takes in a char variable.
     * @return returns the position of the given character.
     */
    public int indexOf(char character) {
        for (int iterator = 0; iterator < this.alphabetLength; iterator++) {
            if (this.rotor[iterator] == character) {
                return iterator;
            }
        }
        return -1;
    }

    /**
     * Method to return the number of turns the rotor has done.
     *
     * @return returns the turn position.
     */
    public int getTurn() {
        return this.turn;
    }

    /**
     * Turns the rotor by the number of times specified by the turns variable.
     *
     * @param turns sets the motors starting turns.
     */
    public void setTurn(int turns) {
        for (int iterator = 0; iterator < turns; iterator++) {
            turn();
        }

    }

    /**
     * Method to rotate the rotor by one revolution.
     */
    public void turn() {
        char character = this.rotor[0];

        for (int i = 1; i < this.alphabetLength; i++) {
            this.rotor[i - 1] = this.rotor[i];
        }

        this.rotor[this.alphabetLength - 1] = character;

        this.turn++;
    }

    /**
     * Method to find a letter in a specified location of the array.
     *
     * @param index takes in an integer.
     * @return returns the letter in the specified location.
     */
    public char charAt(int index) {
        if (index > this.alphabetLength) {
            System.out.println("This is greater than alphabetLength");
            return 'a';
        }
        return this.rotor[index];
    }

    /**
     * Sets the alphabet for the rotor.
     */
    public int getSize() {
        return this.alphabetLength;
    }

    /**
     * Method to reset the rotor to its original position.
     */
    public void resetRotor() {
        this.rotor = this.defaultRotor;
    }
}
