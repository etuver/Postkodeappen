package no.ntnu.eventu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class for managing reading from file
 * No writing to file here as file is downloaded from www.bring.no and should not be edited
 * @author Eventu
 *
 */
public class FileManager {


    /**
     * Method to read post addresses from a file and send them to a register
     * @param postalAdressRegister the register to send the post addresses to
     * @param fileName A string with the filepath to the file
     * @throws FileNotFoundException if file is not found
     * @throws IllegalArgumentException if an error adding a Postal adress
     */
    public void readFromFile(PostalAdressRegister postalAdressRegister, String fileName) throws FileNotFoundException, IllegalArgumentException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (!line.isBlank()){
                    String[] lineInfo = line.split("\t");
                    if (lineInfo.length ==5){
                            postalAdressRegister.registerPostalAdress(lineInfo[0], lineInfo[1], lineInfo[2], lineInfo[3], lineInfo[4]);
                    }
                }
        }
        scanner.close();
    }
}