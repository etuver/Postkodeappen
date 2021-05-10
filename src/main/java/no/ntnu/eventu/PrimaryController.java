package no.ntnu.eventu;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {


    public TextField searchTxt;
    public Button showAllBtn;
    public Button searchBtn;
    public Label errorLabel;
    @FXML
    private TableView postalAdressTable;
    /**
     * Get postal adress register
     */
    PostalAdressRegister postalAdressRegister = PostalAdressRegister.getInstance();



    private void addTestData(){
        postalAdressRegister.registerPostalAdress("0200","Oslo", "4","Oslo","B");
        postalAdressRegister.registerPostalAdress("2020","Skedsmokorset", "5","Skedsmo","G");
        postalAdressRegister.registerPostalAdress("7020","Trondheim", "6","Trøndelag","S");
        postalAdressRegister.registerPostalAdress("7500","Steinkjer", "7","Trøndelag","G");
    }





    @FXML
    private void initialize(){
        addTestData();

        TableColumn<PostalAdress, String> postalCodeColumn = new TableColumn<>("Postnummer");
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        postalAdressTable.getColumns().add(postalCodeColumn);

        TableColumn<PostalAdress, String> postalAdressColumn = new TableColumn<>("Poststed");
        postalAdressColumn.setCellValueFactory(new PropertyValueFactory<>("postalAdress"));
        postalAdressTable.getColumns().add(postalAdressColumn);

        TableColumn<PostalAdress, String> municipalityNameColumn = new TableColumn<>("Kommune");
        municipalityNameColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityName"));
        postalAdressTable.getColumns().add(municipalityNameColumn);

        TableColumn<PostalAdress, String> postalCodeCategoryColumn = new TableColumn<>("Kategori");
        postalCodeCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("postalAdressCategory"));
        postalAdressTable.getColumns().add(postalCodeCategoryColumn);



        // Fill table
        //postalAdressTable.getItems().addAll(postalAdressRegister.getPostalAdressRegister());

        showAllBtn.setOnAction(event -> {
            postalAdressTable.getItems().addAll(postalAdressRegister.getPostalAdressRegister());
                });

        searchBtn.setOnAction(event -> {
            postalAdressTable.getItems().clear();

            if (searchTxt.getText().matches("^\\d|\\d{2}|\\d{3}|\\d{4}$")){
                postalAdressTable.getItems().addAll(postalAdressRegister.searchByPostalCode(searchTxt.getText()));
            }else {
                postalAdressTable.getItems().addAll(postalAdressRegister.searchByAdress(searchTxt.getText()));
            }

        });

    }







}
