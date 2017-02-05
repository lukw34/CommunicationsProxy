package controller.interfaces;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

/**
 * Interfejs reprezentujący kontroller odpowiedzialny za logikę okna dialogowego.
 *
 * @param <T> Widok jaki zostanie podpiœty do kontrollera.
 */
public interface RecipientGroupCtrlInterface<T extends JPanel> extends ViewController<T> {
    /**
     * Zapewnia dostep do listy widokow adresata.
     *
     * @return Strumien zawierajacy gotowe widoki.
     */
    Stream<Component> getRecipients();

    /**
     * Zapewnienie udostepnienia losowego odbiorcy.
     *
     * @return Losowy odbiorca.
     */
    RecipientCtrlInterface getRandomRecipient();

    /**
     * Reakcja na zmiane parametrow.
     */
    void onParamsChange();
}
