package no.ntnu.eventu;

/**
 * A class representing a postal address
 *
 * @author Eventu
 */
public class PostalAdress {

    private final String postalCode;
    private final String postalAddress;
    private final String municipalityCode;
    private final String municipalityName;
    private final String postalAdressCategory;

    /**
     * method to create a postal address
     *
     * @param postalCode           four digit number
     * @param postalAddress        address for the postal code can not be empty
     * @param municipalityCode     not used in this app but is given by the data. not relevant for the user in this application, can not be empty
     * @param municipalityName     name of the municipality can not be empty
     * @param postalAdressCategory category of the postal adress. can be B, F, G, P or S.
     */
    public PostalAdress(String postalCode, String postalAddress, String municipalityCode, String municipalityName, String postalAdressCategory) {
        if (!postalCodeValidator(postalCode)) {
            throw new IllegalArgumentException("Invalid postal code");
        } else if (postalAddress.isBlank()) {
            throw new IllegalArgumentException("Invalid postal address");
        } else if (municipalityCode.isBlank()) {
            throw new IllegalArgumentException("invalid municipality Code");
        } else if (municipalityName.isBlank()) {
            throw new IllegalArgumentException("invalid municipality name");
        } else if (postalAdressCategory.isBlank()) {
            throw new IllegalArgumentException("invalid postal address category");
        }
        this.postalCode = postalCode;
        this.postalAddress = postalAddress;
        this.municipalityCode = municipalityCode;
        this.municipalityName = municipalityName;
        this.postalAdressCategory = postalAdressCategory;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public String getPostalAdress() {
        return postalAddress;
    }

    public String getMunicipalityCode() {
        return municipalityCode;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }


    /**
     * Method which return what category the postal address is as a description instead of character
     *
     * @return the category description
     */
    public String getPostalAdressCategory() {
        if (postalAdressCategory.equalsIgnoreCase("B")) {
            return "Gateadresser og postbokser";
        } else if (postalAdressCategory.equalsIgnoreCase("F")) {
            return "Flere bruksomr??der(Felles)";
        } else if (postalAdressCategory.equalsIgnoreCase("G")) {
            return "Gateadresser";
        } else if (postalAdressCategory.equalsIgnoreCase("P")) {
            return "Postbokser";
        } else if (postalAdressCategory.equalsIgnoreCase("S")) {
            return "Servicepostnummer";
        } else {
            return "Ukjent";
        }
    }

    /**
     * Method to validate a postal code
     * A valid postal code is any four digit number
     *
     * @param postalCode the postal code to check
     * @return true if valid, else false
     */
    private boolean postalCodeValidator(String postalCode) {
        return postalCode.matches("^[0-9]*$") && postalCode.length() == 4;
    }


    /**
     * Autogenerated toString() method
     *
     * @return a string with all parameters
     */
    @Override
    public String toString() {
        return "PostalAdress{" +
                "postalCode='" + postalCode + '\'' +
                ", postalAdress='" + postalAddress + '\'' +
                ", municipalityCode='" + municipalityCode + '\'' +
                ", municipalityName='" + municipalityName + '\'' +
                ", postalAdressCategory='" + postalAdressCategory + '\'' +
                '}';
    }


}
