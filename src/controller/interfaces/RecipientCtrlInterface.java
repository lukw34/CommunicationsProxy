package controller.interfaces;

import java.awt.*;

/**
 * Interfejs reprezentujący kontroller odpowiedzialny za logikę pojedynczego adresata.
 *
 * @param <T> Widok jaki zostanie podpiœty do kontrollera.
 */
public interface RecipientCtrlInterface<T extends Component> extends ViewController<T> {
    /**
     * Umozliwia ustawienie stanu.
     *
     * @param state Nowy stan.
     */
    void setState(RecipientState state);

    /**
     * Udostepnia mozliwosc rysowania adresata.
     *
     * @param g Grafika
     */
    void paint(Graphics g);

    /**
     * Udostepnienie mozliwosci odswiezenia grafiki.
     */
    void repaint();

    /**
     * Zapewnienie metody do obsluzenia sytuacji otrzymania wiadomosci.
     *
     * @param message
     * @return
     */
    boolean onReciveMessage(MessageCtrlInterface message);

    /**
     * Udostepnia stan adresta.
     *
     * @return Stan odpowiadajacy pustemu adresatowi.
     */
    RecipientState getEmpty();

    /**
     * Udostepnia stan adresta.
     *
     * @return Stan odpowiadajacy gotowosci adresata.
     */
    RecipientState getReady();
}
