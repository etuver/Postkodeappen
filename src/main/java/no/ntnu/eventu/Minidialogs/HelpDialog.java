package no.ntnu.eventu.Minidialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.FlowPane;
import no.ntnu.eventu.Interfaces.MiniDialogFactoryInterface;

public class HelpDialog implements MiniDialogFactoryInterface {
    @Override
    public Dialog getDialog() {
        Alert helpAlert = new Alert(Alert.AlertType.INFORMATION);
        helpAlert.setTitle("Hjelp");
        helpAlert.setHeaderText("Hjelp");
        Label contentText = new Label(  "Denne appen inneholder alle postnummer i fastlandsNorge samt Svaldbard og Jan Mayen\n\n" +
                "For å søke skriv inn hele eller deler av postnummer eller poststed / kommune og trykk søk / enter\n\n" +
                "Dersom du ikke finner det du søker etter prøv å endre din søketekst\n\n" +
                "Et søk må minimum være på to tall eller bokstaver\n\n\n" +
                "Opplever du problemer med appen vennligst ta kontakt:" +
                "");

        Hyperlink hyperlink = new Hyperlink("https://gitlab.stud.idi.ntnu.no/eventu/postkodeappen");
        hyperlink.setOnAction(event -> {
                    final Clipboard clipboard = Clipboard.getSystemClipboard();
                    final ClipboardContent content = new ClipboardContent();
                    content.putString(hyperlink.getText());
                    clipboard.setContent(content);
                }
        );
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(contentText,hyperlink);
        helpAlert.getDialogPane().contentProperty().set(flowPane);
        return helpAlert;
    }
}
