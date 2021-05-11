package no.ntnu.eventu.Minidialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.FlowPane;
import no.ntnu.eventu.Interfaces.MiniDialogFactoryInterface;

public class AboutDialog implements MiniDialogFactoryInterface {
    @Override
    public Dialog getDialog() {
        Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
        FlowPane fp = new FlowPane();
        Label label = new Label("App laget av " +
                "\n(C)Even Tuverud\n" +
                "2021-05-11\n" +
                "\n" +
                "Se GitLab for mer info og kontakt:\n");

        Hyperlink hyperlink = new Hyperlink("https://gitlab.stud.idi.ntnu.no/eventu/postkodeappen");
        Label bottomLabel = new Label("(Klikk linken for å kopiere til utklippstavle)");
        hyperlink.setOnAction(event -> {
                    final Clipboard clipboard = Clipboard.getSystemClipboard();
                    final ClipboardContent content = new ClipboardContent();
                    content.putString(hyperlink.getText());
                    clipboard.setContent(content);
                }
        );
        fp.getChildren().addAll(label, hyperlink, bottomLabel);
        aboutAlert.getDialogPane().contentProperty().set(fp);
        aboutAlert.setTitle("Om");
        aboutAlert.setHeaderText("Postkode Appen \nv0.1-SNAPSHOT");
        return aboutAlert;
    }
}
