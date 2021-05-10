package no.ntnu.eventu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

    public void readFromFile(PostalAdressRegister postalAdressRegister, String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] lineInfo = line.split("\t");
            postalAdressRegister.registerPostalAdress(lineInfo[0], lineInfo[1], lineInfo[2], lineInfo[3], lineInfo[4]);
        }
        scanner.close();
    }




}
