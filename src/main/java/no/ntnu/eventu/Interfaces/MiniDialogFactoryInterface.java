package no.ntnu.eventu.Interfaces;

import javafx.scene.control.Dialog;

/**
 * Interface for the dialog factory
 * @param <D>
 */
public interface MiniDialogFactoryInterface<D> {
    Dialog<D> getDialog();
}
