package no.ntnu.eventu.Minidialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import no.ntnu.eventu.Interfaces.MiniDialogFactoryInterface;

public class ExitDialog implements MiniDialogFactoryInterface {
    @Override
    public Dialog getDialog() {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "Er du sikker på at du vil avslutte?", ButtonType.YES, ButtonType.NO);
        exitAlert.setTitle("Bekreft");
        exitAlert.setHeaderText("Avslutte?");
        exitAlert.setAlertType(Alert.AlertType.WARNING);
        return exitAlert;
    }
}
