package no.ntnu.eventu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostalAdressRegister {

    private ArrayList<PostalAdress> postalAdressRegister;

    public PostalAdressRegister(){
        this.postalAdressRegister = new ArrayList<>();
    }

    public void registerPostalAdress(String postalCode, String postalAdress, String municipalityCode, String municipalityName, String postalAdressCategory){
        postalAdressRegister.add(new PostalAdress(postalCode,postalAdress,municipalityCode,municipalityName,postalAdressCategory));
    }


    public ArrayList<PostalAdress> getPostalAdressRegister() {
        return postalAdressRegister;
    }

    /**
     *
     * @param postalCode
     * @return

    public ArrayList<PostalAdress> searchByPostalCode(String postalCode){
        ArrayList result = new ArrayList();
        for (int i = 0; i < postalAdressRegister.size(); i++){
            if (postalAdressRegister.get(i).getPostalCode().equals(postalCode)){
                result.add(postalAdressRegister.get(i));
            }
        }
        return result;
    }  */
    public List<PostalAdress> searchByPostalCode(String postalCode){
        List<PostalAdress> codeMatches = postalAdressRegister.stream()
                .filter(p -> p.getPostalCode().contains(postalCode))
                .collect(Collectors.toList());
        return codeMatches;
    }


    public List<PostalAdress> searchByAdress(String adress){
        List<PostalAdress> matches = postalAdressRegister.stream()
                .filter(p -> p.getPostalAdress().toLowerCase().contains(adress.toLowerCase()) || p.getMunicipalityName().toLowerCase().contains(adress.toLowerCase()))
                .collect(Collectors.toList());
        return matches;
    }

    private static final PostalAdressRegister instance = new PostalAdressRegister();

    public static PostalAdressRegister getInstance(){
        return instance;

    }

}
