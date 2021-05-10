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

    public ArrayList<PostalAdress> searchByPostalCode(String postalCode){
        ArrayList result = new ArrayList();
        for (int i = 0; i < postalAdressRegister.size(); i++){
            if (postalAdressRegister.get(i).getPostalCode().equals(postalCode)){
                result.add(postalAdressRegister.get(i));
            }
        }
        return result;
    }


    public List<PostalAdress> searchByAdress(String adress){
        List<PostalAdress> matches = postalAdressRegister.stream()
                .filter(p -> p.getPostalAdress().contains(adress) || p.getMunicipalityName().contains(adress))
                .collect(Collectors.toList());
        return matches;
    }

    private static final PostalAdressRegister instance = new PostalAdressRegister();

    public static PostalAdressRegister getInstance(){
        return instance;

    }

}
