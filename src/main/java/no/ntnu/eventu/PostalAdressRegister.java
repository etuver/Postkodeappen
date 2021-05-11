package no.ntnu.eventu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class representing a register with postal addresses
 * @author Eventu
 */
public class PostalAdressRegister {


    private ArrayList<PostalAdress> postalAdressRegister;

    public PostalAdressRegister(){
        this.postalAdressRegister = new ArrayList<>();
    }


    /**
     * Method to add a postal adress to the register
     * @param postalCode four digits number
     * @param postalAdress address for the postal code can not be empt
     * @param municipalityCode not used in this app but is given by the data. not relevant for the user in this application, can not be empty
     * @param municipalityName name of the municipality can not be empty
     * @param postalAdressCategory category of the postal adress. can be B, F, G, P or S.
     * @throws IllegalArgumentException if postal address could not be added
     */
    public void registerPostalAdress(String postalCode, String postalAdress, String municipalityCode, String municipalityName, String postalAdressCategory) throws IllegalArgumentException{
        postalAdressRegister.add(new PostalAdress(postalCode,postalAdress,municipalityCode,municipalityName,postalAdressCategory));
    }


    public ArrayList<PostalAdress> getPostalAdressRegister() {
        return postalAdressRegister;
    }


    /**
     * Method to search for postal address by postal code
     * Will return any postal address matching or partially matching
     * @param postalCode the postal code to search for
     * @return any matching or partially matching post address
     */
    public List<PostalAdress> searchByPostalCode(String postalCode){
        return postalAdressRegister.stream()
                .filter(p -> p.getPostalCode().contains(postalCode))
                .collect(Collectors.toList());
    }


    /**
     * Method to search for postal address by area
     * will return any postal address matching or partially matching the search criteria
     * @param adress the search criteria / area to search for
     * @return any matching or partially matching address
     */
    public List<PostalAdress> searchByAdress(String adress){
        return postalAdressRegister.stream()
                .filter(p -> p.getPostalAdress().toLowerCase().contains(adress.toLowerCase()) || p.getMunicipalityName().toLowerCase().contains(adress.toLowerCase()))
                .collect(Collectors.toList());
    }

    private static final PostalAdressRegister instance = new PostalAdressRegister();

    public static PostalAdressRegister getInstance(){
        return instance;

    }

}
