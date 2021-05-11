package no.ntnu.eventu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the PostalAdressRegister class
 * Tests are concluded with JUnit5
 * @author Eventu
 */
class PostalAdressRegisterTest {

    PostalAdressRegister register = new PostalAdressRegister();

    /**
     * Just adding some postal addresses to the register initially
     */
    @BeforeEach
    public void setup(){
        register.registerPostalAdress("7020", "Trondheim","5001","Trøndelag","G");
        register.registerPostalAdress("0800", "Oslo","0200","Oslo","F");
        register.registerPostalAdress("9590", "Hasvik","5001","Hasvik","B");
        register.registerPostalAdress("7500", "Levanger","5001","Trøndelag","B");
    }

    /**
     * Positive test testing registering a new postal address to the register
     * Asserting the Postal address has been added to the register in addition to the four initially added
     */
    @Test
    public void testRegisterPostalAddress(){
        register.registerPostalAdress("3477", "Båtstø","5001","Asker","S");
        assertEquals(5, register.getPostalAdressRegister().size());
    }


    /**
     * Negative test
     * Testing registering a new Postal address with invalid Postal Code
     * Asserting it throws exceptions accordingly
     * Asserting no postal addresses has been added to the register
     */
    @Test
    public void testRegisterNewPostalAddressInvalidPostalCode(){
        assertThrows(IllegalArgumentException.class,
                () -> { register.registerPostalAdress("", "Båtstø","5001","Asker","S");});
        assertThrows(IllegalArgumentException.class,
                () -> { register.registerPostalAdress("123", "Båtstø","5001","Asker","S");});
        assertThrows(IllegalArgumentException.class,
                () -> { register.registerPostalAdress("12345", "Båtstø","5001","Asker","S");});
        assertThrows(IllegalArgumentException.class,
                () -> { register.registerPostalAdress("123x", "Båtstø","5001","Asker","S");});
        assertEquals(4, register.getPostalAdressRegister().size());
    }

    /**
     * Negative test
     * Testing registering a new Postal address with empty parameters
     * Asserting it throws exceptions accordingly
     * Asserting no postal addresses has been added to the register
     */
    @Test
    public void testRegisterNewPostalAddressNullParameters(){
        assertThrows(IllegalArgumentException.class,
                () -> { register.registerPostalAdress("", "Båtstø","5001","Asker","S");});
        assertThrows(IllegalArgumentException.class,
                () -> { register.registerPostalAdress("1234", "","5001","Pappesker","S");});
        assertThrows(IllegalArgumentException.class,
                () -> { register.registerPostalAdress("1234", "Båtstørrelse","","Flasker","S");});
        assertThrows(IllegalArgumentException.class,
                () -> { register.registerPostalAdress("1235", "Båtstøtte","5001","","S");});
        assertThrows(IllegalArgumentException.class,
                () -> { register.registerPostalAdress("1235", "Båtstøtte","5001","Rasker","");});
        assertEquals(4, register.getPostalAdressRegister().size());
    }

    /**
     * Positive test testing search by Postal code method
     * Asserting the size of the list returned is as expected
     */
    @Test
    public void testSearchByPostalCode(){
        assertEquals(0,register.searchByPostalCode("99").size());
        assertEquals(1, register.searchByPostalCode("7020").size());
        assertEquals(2, register.searchByPostalCode("00").size());
    }

    /**
     * Positive test  testing search by adress / area
     * asserting the size of the list returned is as expected
     */
    @Test
    public void testSeachByAdress(){
        assertEquals(0, register.searchByAdress("ko").size());
        assertEquals(1, register.searchByAdress("Trondheim").size());
        assertEquals(2, register.searchByAdress("Trøndelag").size());
        assertEquals(2, register.searchByAdress("trø").size());
        assertEquals(1, register.searchByAdress("os").size());
        assertEquals(1, register.searchByAdress("oslo").size());


    }






}