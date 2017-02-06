package controller.interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Interfejs reprezentujący kontroller odpowiedzialny za logikę naglowka.
 *
 * @param <T> Widok jaki zostanie podpiœty do kontrollera.
 */
public interface HeaderCtrlInterface<T extends Component> extends ViewController<T> {
    /**
     * Akcja obslugujaca dodanie watku.
     *
     * @param event Obiekt akcji.
     */
    void onAddThread(ActionEvent event);

    /**
     * Akcja obslugujaca dodanie wiadomosci.
     *
     * @param event Obiekt akcji.
     */
    void onAddMessage(ActionEvent event);
}
