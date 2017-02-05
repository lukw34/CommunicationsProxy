package controller.interfaces;

import models.Message;

import java.awt.*;

/**
 * Interfejs odpowiedzialny za logike zwiazana z prezentacja wiadomosci przechowywanej w posredniku.
 *
 * @param <T> Widok reprezentujacy wiadomosc.
 */
public interface MessageCtrlInterface<T extends Component> extends ViewController<T> {
    /**
     * Metoda umożliwiajaca zmiane stanu.
     *
     * @param state Nowy stan
     */
    void setState(MessageState state);

    /**
     * Metoda umozliwiajaca ustawienie ustawienie nowych danych dotyczacych wiadomosci.
     *
     * @param message Nowa wiadomość
     */
    void setMessage(Message message);

    /**
     *  Metoda umozliwiajaca dostep do wiadomosci z kontrollera.
     *  @return Wiadomosc.
     */
    Message getMessage();

    /**
     * Metoda umozliwajaca rysowanie grafiki.
     *
     * @param g Obiekt grafiki
     */
    void paint(Graphics g);

    /**
     * Metoda umozliwiajaca odswiezenie grafiki.
     */
    void repaint();

    /**
     * Udostepnienie stanu odpowiadajacego za puste miejsce w posredniku.
     *
     * @return Stan empty.
     */
    MessageState getEmpty();

    /**
     * Udostepnienie stanu odpowiadajacego za oczekajaca wiadomosc.
     *
     * @return Stan waiting.
     */
    MessageState getWaiting();

    /**
     * Umożliwia wyslanie wiadomosci, metoda powinna zawierac logike zwiazana z ta czynnoscia.
     *
     * @throws InterruptedException Zwiazany z wyjatkami rzucanym w czasie pracy watku.
     */
    void sendIfPossible() throws InterruptedException;
}
