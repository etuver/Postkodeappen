package no.ntnu.eventu;

public class PostalAdress {

    private final String postalCode;
    private final String postalAddress;
    private final String municipalityCode;
    private final String municipalityName;
    private final String postalAdressCategory;


    public PostalAdress(String postalCode, String postalAddress, String municipalityCode, String municipalityName, String postalAdressCategory){
        if (!postalCodeValidator(postalCode)){
            throw new IllegalArgumentException("Invalid postal code");
        }else if (postalAddress.isBlank() ){
            throw new IllegalArgumentException("Invalid postal address");
        }else if (municipalityCode.isBlank()){
            throw new IllegalArgumentException("invalid municipality Code");
        }else if (municipalityName.isBlank()){
            throw new IllegalArgumentException("invalid municipality name");
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

    public String getPostalAdressCategory() {
        if (postalAdressCategory.equalsIgnoreCase("B")){
            return "Gateadresser og postbokser";
        }else if (postalAdressCategory.equalsIgnoreCase("F")){
            return "Flere bruksområder(Felles)";
        }else if (postalAdressCategory.equalsIgnoreCase("G")){
            return "Gateadresse";
        }else if (postalAdressCategory.equalsIgnoreCase("P")){
            return "Postbokser";
        }else if (postalAdressCategory.equalsIgnoreCase("S")){
            return "Servicepostnummber";
        }else {
            return "Ukjent";
        }
    }

    private boolean postalCodeValidator(String postalCode){
        return postalCode.matches("^[0-9]*$")&& postalCode.length() == 4;
    }


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
