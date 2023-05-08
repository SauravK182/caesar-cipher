package assignment02;

import input_output_handling.*;
import encryption_algorithm.*;

/**
 * @author Saurav Kiri
 * @since March 2023
 */

public class MyFileReader implements IOHandling {
    private String readFromFile, writeToFile, rawData, processedData;
    private Encryption eAlgorithm;

    // CONSTRUCTORS
    public MyFileReader(String readFromFile) {
        this(readFromFile, "output.txt", new CaesarCipher());
    }

    public MyFileReader(String readFromFile, String writeToFile) {
        this(readFromFile, writeToFile, new CaesarCipher());
    }

    public MyFileReader(String readFromFile, String writeToFile, Encryption eAlgorithm) {
        this.setReadFromFile(readFromFile);
        this.setWriteToFile(writeToFile);
        this.setEAlgorithm(eAlgorithm);
    }

    // GETTERS FOR RETURNING INSTANCE VARS
    public String getReadFromFile() {
        return this.readFromFile;
    }

    public String getWriteToFile() {
        return this.writeToFile;
    }

    public String getRawData() {
        return this.rawData;
    }

    public String getProcessedData() {
        return this.processedData;
    }

    public Encryption getEAlgorithm() {
        return this.eAlgorithm;
    }

    /*
     * SETTERS
     * note that since rawData and processedData are dictated by readFromFile,
     * these should not be manually settable and thus we will not define accessor
     * methods for them.
     */
    public void setReadFromFile(String readFromFile) {
        this.readFromFile = readFromFile;
    }

    public void setWriteToFile(String writeToFile) {
        this.writeToFile = writeToFile;
    }

    public void setEAlgorithm(Encryption eAlgorithm) {
        this.eAlgorithm = eAlgorithm;
    }



    public void readData() {
        this.rawData = readData(this.readFromFile);
        this.processData();
    }

    public void writeData() {
        writeData(this.processedData, this.writeToFile);
    }


    public void processData() {
        /* use replaceFirst() method to get rid of the 'encrypt:' or 'decrypt:' prefix
         * source: https://stackoverflow.com/questions/10897470/
         */
        if (rawData.startsWith("encrypt:")) {
            this.processedData = eAlgorithm.encrypt(this.rawData.replaceFirst("encrypt:", ""));
        } else if (rawData.startsWith("decrypt:")) {
            this.processedData = eAlgorithm.decrypt(this.rawData.replaceFirst("decrypt:", ""));
        } else {
            this.processedData = this.rawData;
        }
    }
}
