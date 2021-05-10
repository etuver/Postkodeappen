package no.ntnu.eventu;

public class PostalAdress {

    private final String postalCode;
    private final String postalAdress;
    private final String municipalityCode;
    private final String municipalityName;
    private final String postalAdressCategory;


    public PostalAdress(String postalCode, String postalAdress, String municipalityCode, String municipalityName, String postalAdressCategory){
        this.postalCode = postalCode;
        this.postalAdress = postalAdress;
        this.municipalityCode = municipalityCode;
        this.municipalityName = municipalityName;
        this.postalAdressCategory = postalAdressCategory;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public String getPostalAdress() {
        return postalAdress;
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

    @Override
    public String toString() {
        return "PostalAdress{" +
                "postalCode='" + postalCode + '\'' +
                ", postalAdress='" + postalAdress + '\'' +
                ", municipalityCode='" + municipalityCode + '\'' +
                ", municipalityName='" + municipalityName + '\'' +
                ", postalAdressCategory='" + postalAdressCategory + '\'' +
                '}';
    }





}
