package no.ntnu.eventu;

import javafx.scene.control.Alert;
import no.ntnu.eventu.Interfaces.MiniDialogFactoryInterface;
import no.ntnu.eventu.Minidialogs.AboutDialog;
import no.ntnu.eventu.Minidialogs.ExitDialog;
import no.ntnu.eventu.Minidialogs.HelpDialog;

public class MiniDialogFactory {

    public MiniDialogFactoryInterface getDialog(DialogType dialogType){
        switch (dialogType){
            case Exit:
                return new ExitDialog();
            case About:
                return new AboutDialog();
            case Help:
                return new HelpDialog();
        }
        return null;
    }


    public enum DialogType{
        Exit,
        About,
        Help
    }



}
