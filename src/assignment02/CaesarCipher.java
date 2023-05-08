package assignment02;

import encryption_algorithm.*;

/**
 * @author Saurav Kiri
 * @since March 2023
 */

public class CaesarCipher implements Encryption {
    private int shiftBit;

    // DEFINE CONSTRUCTORS
    public CaesarCipher() {
        this(1);
    }

    public CaesarCipher(int shiftBit) {
        this.setShiftBit(shiftBit);
    }

    // GETTER FOR SHIFTBIT
    public int getShiftBit() {
        return this.shiftBit;
    }

    // SETTER FOR SHIFTBIT
    public void setShiftBit(int shiftBit) {
        this.shiftBit = shiftBit;
    }

    /*
     * source for charAt() method and String iteration:
     * https://www.geeksforgeeks.org/iterate-over-the-characters-of-a-string-in-java/
     * 
     * source for converting character to ASCII:
     * https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java
     */
    public String encrypt(String plainText) {
        String encryptedText = "";
        // iterate through String; shift each ascii value by shiftBit mod 26
        for (int i = 0; i < plainText.length(); i++) {
            char currChar = plainText.charAt(i);
            int asciiChar = (int) currChar; // converts character to its ascii representation
            char encryptChar = (char) (asciiChar + (this.shiftBit % 26)); // add shiftBit and cast back to character from ascii
            encryptedText = encryptedText + encryptChar;
        }
        return encryptedText;
    }

    public String decrypt(String encryptText) {
        String decryptedText = "";
        // iterate through String; shift each ascii value in reverse by shiftBit mod 26
        for (int i = 0; i < encryptText.length(); i++) {
            char currChar = encryptText.charAt(i);
            int asciiChar = (int) currChar;
            char decryptChar = (char) (asciiChar - (this.shiftBit % 26)); // shift by reverse of shiftBit
            decryptedText = decryptedText + decryptChar;
        }
        return decryptedText;
    }
    
}
