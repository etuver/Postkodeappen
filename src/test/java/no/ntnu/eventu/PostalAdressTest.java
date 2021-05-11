package no.ntnu.eventu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the PostalAdress class
 * Tests are concluded with JUnit5
 * @author Eventu
 */
class PostalAdressTest {

    /**
     * Positive test
     * Testing creating a new postal Adress without errors and asserting the parameters are as expected
     */
    @Test
    public void testNewPostalAdress(){
        PostalAdress postalAdress = new PostalAdress("7020", "Trondheim","5001","Trøndelag","G");
        assertEquals("7020", postalAdress.getPostalCode());
        assertEquals("Trondheim", postalAdress.getPostalAdress());
        assertEquals("5001", postalAdress.getMunicipalityCode());
        assertEquals("Trøndelag", postalAdress.getMunicipalityName());
        assertEquals("Gateadresse", postalAdress.getPostalAdressCategory());
    }

    /**
     * Negative test
     * Testing creating a new postal address with empty fields
     * asserting they throw exceptions accordingly
     */
    @Test
    public void testNewPostalAdressNull(){
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("", "Trondheim", "5001", "Trøndelag","G");});
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("7020", "", "5001", "Trøndelag","G");});
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("7020", "Trondheim", "", "Trøndelag","G");});
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("7020", "Trondheim", "5001", "","G");});
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("7020", "Trondheim", "5001", "","");});
    }

    /**
     * Negative test testing creating new Postal address with invalid postal code
     * asserting they throw exceptions accordingly
     * A valid postal code is a four digits number
     * Indirectly testing the private method postalCodeValidator
     */
    @Test
    public void testNewPostalAdressInvalidCode(){
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("123", "Trondheim", "5001", "","G");});
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("12345", "Trondheim", "5001", "","G");});
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("123x", "Trondheim", "5001", "","G");});
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("123*", "Trondheim", "5001", "","G");});
        assertThrows(IllegalArgumentException.class,
                () -> { PostalAdress p = new PostalAdress("    ", "Trondheim", "5001", "","G");});
    }

    /**
     * Positive test
     * Asserting postal address categories are returned as expected
     */
    @Test
    public void testGetPostalAdressCategory(){
        PostalAdress postalAdressG = new PostalAdress("7020", "Trondheim","5001","Trøndelag","G");
        PostalAdress postalAdressF = new PostalAdress("0800", "Oslo","0200","Oslo","F");
        PostalAdress postalAdressB = new PostalAdress("9590", "Hasvik","5001","Hasvik","B");
        PostalAdress postalAdressP = new PostalAdress("9730", "Karasjok","5001","Karasjohka Karasjohka","P");
        PostalAdress postalAdressS = new PostalAdress("3477", "Båtstø","5001","Asker","S");
        PostalAdress postalAdressX = new PostalAdress("7500", "Levanger","5001","Trøndelag","X");
        assertEquals("Gateadresse", postalAdressG.getPostalAdressCategory());
        assertEquals("Flere bruksområder(Felles)", postalAdressF.getPostalAdressCategory());
        assertEquals("Gateadresser og postbokser", postalAdressB.getPostalAdressCategory());
        assertEquals("Postbokser", postalAdressP.getPostalAdressCategory());
        assertEquals("Servicepostnummer", postalAdressS.getPostalAdressCategory());
        assertEquals("Ukjent", postalAdressX.getPostalAdressCategory());

    }





}