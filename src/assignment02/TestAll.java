package assignment02;

import java.lang.invoke.CallSite;

/**
 * @author Saurav Kiri
 * @since March 2023
 */

public class TestAll {

	public static void main(String[] args) {

		// create new MyFileReader object and call the default inherited readData() and writeData() methods
		MyFileReader fr = new MyFileReader("sample_input.txt");
		String readData = fr.readData("sample_input.txt");
		fr.writeData(readData, "sample_output.txt");

		// testing encryption/decryption with CeaserCipher, shiftBit = 1
		CaesarCipher cs = new CaesarCipher(1);
		String original = "good morning";
		String encrypted = cs.encrypt(original);
		String decrypted = cs.decrypt(encrypted);
		System.out.println("Original string: " + original + "\nEncrypted string: " + encrypted + "\nDecrypted string: " + decrypted);
		System.out.println("Is original the same as decrypted? " + decrypted.equals(original) + "\n");

		

		// Testing with 'encrypt:' in prefix for sample input, shiftBit = 10
		MyFileReader r2 = new MyFileReader("sample_input.txt", "processed_output.txt", new CaesarCipher(10));
		r2.readData();
		r2.writeData();
		System.out.println("Original string: " + r2.getRawData() +
						   "Processed string: " + r2.getProcessedData());

		// checking to make sure the encryption was done correctly
		String spongebobDecrypted = r2.getEAlgorithm().decrypt(r2.getProcessedData());
		System.out.println("Decrypted string: " + spongebobDecrypted + "\n");

		// Testing with 'decrypt:' in prefix for sample input, shiftBit = 10
		MyFileReader r3 = new MyFileReader("sample_input_decrypt.txt", "processed_output_decrypt.txt", new CaesarCipher(10));
		r3.readData();
		r3.writeData();
		System.out.println("Original string: " + r3.getRawData() +
						   "Processed string: " + r3.getProcessedData());
		
		// check to make sure the decryption was done correctly
		String spongebobEncrypted = r3.getEAlgorithm().encrypt(r3.getProcessedData());
		System.out.println("Encrypted string: " + spongebobEncrypted + "\n");

		// final test - when neither encrypt: nor decrypt: is the prefix for rawData
		MyFileReader r4 = new MyFileReader("sample_input_noprefix.txt", "processed_output_noprefix.txt", new CaesarCipher(10));
		r4.readData();
		r4.writeData();
		System.out.println("Original string: " + r4.getRawData() + 
						   "Processed string: " + r4.getProcessedData());
		System.out.println("Read and processed data are the same? " + r4.getProcessedData().equals(r4.getRawData()));
	}
	
	
}
