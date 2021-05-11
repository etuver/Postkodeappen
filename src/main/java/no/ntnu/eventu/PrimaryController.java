package no.ntnu.eventu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import no.ntnu.eventu.Minidialogs.AboutDialog;
import no.ntnu.eventu.Minidialogs.ExitDialog;
import no.ntnu.eventu.Minidialogs.HelpDialog;

/**
 * Controller for the app primary view
 * @author Eventu
 */
public class PrimaryController {

    //Tableview
    @FXML
    private TableView postalAdressTable;

    //Textfield for user input with search text
    @FXML
    public TextField searchTxt;

    //Buttons
    @FXML
    public Button showAllBtn;
    @FXML
    public Button searchBtn;
    @FXML
    public Label errorLabel;

    //Menu items
    @FXML
    public MenuItem closeMenuBtn;
    @FXML
    public MenuItem helpMenuBtn;
    @FXML
    public MenuItem aboutMenuBtn;


    /**
     * Get postal address register
     */
    PostalAdressRegister postalAdressRegister = PostalAdressRegister.getInstance();

    /**
     * Get FileManager
     */
    FileManager fileManager = new FileManager();


    /**
     * Some test data
     */
    private void addTestData() {
        postalAdressRegister.registerPostalAdress("0200", "Oslo", "4", "Oslo", "B");
        postalAdressRegister.registerPostalAdress("2020", "Skedsmokorset", "5", "Skedsmo", "G");
        postalAdressRegister.registerPostalAdress("7020", "Trondheim", "6", "Trøndelag", "S");
        postalAdressRegister.registerPostalAdress("7500", "Steinkjer", "7", "Trøndelag", "G");
    }


    /**
     * Method initialized when the controller is started
     * imports data and show all postal numbers in the table on boot
     * also handles action events
     */
    @FXML
    private void initialize() {
        //addTestData();
        importData();
        handleShowAll();

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

        postalAdressTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Actionevents
        helpMenuBtn.setOnAction(event -> {
            handleHelp();
        });

        aboutMenuBtn.setOnAction(event -> {
            handleAbout();
        });

        closeMenuBtn.setOnAction(event -> {
            handleClose();
        });

        showAllBtn.setOnAction(event -> {
            handleShowAll();
        });

        searchBtn.setOnAction(event -> {
            handleSearch();
        });


        //Pressing enter button while typing in seachtext will press handleSeach()
        searchTxt.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER){
                    handleSearch();
                }
            }
        });
    }



    /**
     * Handles user pressing search button
     * A search must be minimum two characters long
     * If the input is a a number with four or less digits searches for postal code, else searches addresses
     */
    private void handleSearch() {
        errorLabel.setText("");
        if (searchTxt.getText().length() <2 || searchTxt.getText().isBlank()){
            errorLabel.setText("Vennligst fyll inn minst to tall eller bokstaver for å søke");
        }else {
        clearTable();
        if (searchTxt.getText().matches("^\\d|\\d{2}|\\d{3}|\\d{4}$")) {
            postalAdressTable.getItems().addAll(postalAdressRegister.searchByPostalCode(searchTxt.getText()));
        } else {
            postalAdressTable.getItems().addAll(postalAdressRegister.searchByAdress(searchTxt.getText()));
        }}
    }

    /**
     * Handles if user presses show all button
     * Shows all postal codes
     */
    private void handleShowAll() {
        //errorLabel.setText("");
        clearTable();
        postalAdressTable.getItems().addAll(postalAdressRegister.getPostalAdressRegister());
    }

    /**
     * Handles user pressing the close menu item
     * pops a confirm dialog and if user clicks yes shuts down
     */
    private void handleClose() {
        ExitDialog exitDialog = new ExitDialog();
        if (exitDialog.getDialog().showAndWait().get() == ButtonType.YES){
            Platform.exit();
        }
    }

    /**
     * Handles user pressing the help menu item
     * opens a new HelpDialog
     */
    private void handleHelp() {
        HelpDialog helpDialog = new HelpDialog();
        helpDialog.getDialog().showAndWait();


    }

    /**
     * Handles user pressing the about menu item
     * Opens a new AboutDialog
     */
    private void handleAbout() {
        AboutDialog aboutDialog = new AboutDialog();
        aboutDialog.getDialog().showAndWait();
    }


    /**
     * Gets data from chosen text file and puts it into the register
     * Puts any exception messages to the error label
     */
    private void importData() {
        try {
            fileManager.readFromFile(postalAdressRegister, "src/main/resources/no/ntnu/eventu/Postnummerregister.txt");
        } catch (FileNotFoundException |IllegalArgumentException f) {
            errorLabel.setText("Det er en feil i filen: "+f.getMessage());
        }
    }

    /**
     * Method to clear the tableview
     */
    private void clearTable() {
        postalAdressTable.getItems().clear();
    }


}
