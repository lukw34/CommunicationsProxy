package controller.interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Interfejs reprezentujący kontroller odpowiedzialny za logikę okna dialogowego.
 *
 * @param <T> Widok jaki zostanie podpiœty do kontrollera.
 */
public interface DialogCtrlInterface<T, V extends Component> extends ViewController<V> {
    /**
     * Zapewnienie mozliwosci otwrcia okna dialogowego.
     */
    void showDialog();

    /**
     * Akcja podczas zauktualizowania wartosci.
     *
     * @param numberOfMessage Nowa wartosc.
     */
    void changeMessageQuantity(T numberOfMessage);

    /**
     * Akcja podczas zauktualizowania wartosci.
     *
     * @param numberOfThreads nowa wartosc.
     */
    void changeNumberOfThreads(T numberOfThreads);

    /**
     * Akcja odpowiedzialna za zamkniecie okna dialogowego.
     *
     * @param actionEvent Akcja okna dialogowego.
     */
    void closeDialog(ActionEvent actionEvent);

    /**
     * Umozliwienie dodania kontrolerow, ktore reaguja na zmiane parametrow.
     *
     * @param viewController Zainteresowane kontrollery.
     */
    void addSubscriber(DialogSubscriber viewController);
}
