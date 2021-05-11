package no.ntnu.eventu;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the FileManager class
 * Tests are concluded with JUnit5
 * @author Eventu
 */
class FileManagerTest {
    PostalAdressRegister register = new PostalAdressRegister();
    FileManager fileManager = new FileManager();


    /**
     * Positive test
     * Testing successfully reading from a file
     * Reads the from the testfile and adds to the register
     * Testfile has 19 Postal addresses
     */
    @Test
    public void testReadFromFileSuccessfully() throws FileNotFoundException {
        fileManager.readFromFile(register, "src/test/resources/TestfileSuccess.txt");
        assertEquals(19, register.getPostalAdressRegister().size());
        assertEquals(1,register.searchByAdress("blommen").size());
    }

    /**
     * Negative test
     * Testing reading from a non-existent file
     * asserting throws exception accordingly
     */
    @Test
    public void testReadFromFileNotFound() {
        assertThrows(FileNotFoundException.class,
                () -> {  fileManager.readFromFile(register, "ThisisNoFile.txt");;});
    }

    /**
     * Testing reading from a empty file
     * @throws FileNotFoundException
     */
    @Test
    public void testReadFromFileEmpty() throws FileNotFoundException {
        fileManager.readFromFile(register,"src/test/resources/TestFileEmpty.txt" );
        assertEquals(0, register.getPostalAdressRegister().size());
    }

    /**
     * Testing reading from a file with a blank line
     * @throws FileNotFoundException
     */
    @Test
    public void testReadFromFileBlankLine() throws FileNotFoundException {
        fileManager.readFromFile(register,"src/test/resources/TestFileBlankLine.txt");
        assertEquals(15, register.getPostalAdressRegister().size());
    }


    /**
     * Positive  test
     * Testing reading from a file with invalid Post adress inputs
     * @throws FileNotFoundException
     */
    @Test
    public void testReadFromFileInvalidInput() throws FileNotFoundException {

           fileManager.readFromFile(register,"src/test/resources/TestFileInvalidAdress.txt");
        assertEquals(17, register.getPostalAdressRegister().size());
    }


}