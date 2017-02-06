package controller.implementations;

import controller.implementations.message.MessageEmpty;
import controller.implementations.message.MessageProcessing;
import controller.implementations.message.MessageWaiting;
import controller.interfaces.MessageCtrlInterface;
import controller.interfaces.MessageState;
import models.Message;
import utils.Timeout;
import views.MessageView;
import views.SimpleView;

import java.awt.*;
import java.util.concurrent.Semaphore;

/**
 * Klasa implementujaca kontroler odpowiadajacy wiadomosci.
 */
public class MessageCtrl implements MessageCtrlInterface<MessageView> {
    private Semaphore semaphore;

    private MessageState waiting;
    private MessageState empty;
    private MessageState processing;

    private MessageState actualState;

    private SimpleView<MessageView> messageView;
    private Message message;

    /**
     * Tworzy obiekt klasy MessageCtrl
     */
    MessageCtrl() {
        this.messageView = new MessageView(this);
        this.empty = new MessageEmpty();
        this.waiting = new MessageWaiting();
        this.processing = new MessageProcessing();
        this.semaphore = new Semaphore(1);

        this.actualState = this.empty;
    }

    /**
     * Metoda ustawiajaca nowy stan;
     *
     * @param state Nowy stan
     */
    @Override
    public void setState(MessageState state) {
        this.actualState = state;
        this.repaint();
    }

    /**
     * Metoda podmieniajaca przechowywana wiadomosc.
     *
     * @param message Nowa wiadomość
     */
    @Override
    public void setMessage(Message message) {
        this.message = message;
    }

    /**
     * Udostepnia przechowywana wiadomosc.
     *
     * @return Wiadomosc
     */
    @Override
    public Message getMessage() {
        return message;
    }

    /**
     * Metoda rysująca grafike na podstawie aktualnego stanu
     *
     * @param g grafika
     */
    @Override
    public void paint(Graphics g) {
        this.actualState.paint(g, new Point(0, 0));
    }

    /**
     * Metod odświeżająca wygląd grafiki
     */
    @Override
    public void repaint() {
        messageView.repaint();
    }

    /**
     * Zwraca stan odpowiadjący pustej wiadomości.
     *
     * @return Stan odpowiadjący pustej wiadomości.
     */
    @Override
    public MessageState getEmpty() {
        return empty;
    }

    /**
     * Zwraca stan odpowiadjący oczekujacej wiadomości.
     *
     * @return Stan odpowiadjący oczekujacej wiadomości.
     */
    @Override
    public MessageState getWaiting() {
        return waiting;
    }

    /**
     * Metoda wysylajaca wiadomosc kiedy to mozliwe. Odpowiada rowniez za odpowiednia manipulacje stanem.
     *
     * @throws InterruptedException
     */
    @Override
    public void sendIfPossible() throws InterruptedException {
        if (actualState.canProcessing() && semaphore.tryAcquire()) {
            this.setState(this.processing);
            Thread.sleep(Timeout.getTimeout(250, 500));
            new Thread(() -> {
                boolean isSucces = message.getRecipient().onReciveMessage(this);
                if (isSucces) {
                    this.setState(this.empty);
                } else {
                    this.setState(this.waiting);
                }

                semaphore.release();
            }).start();
        }
    }

    /**
     * Zwraca widok wiadomości, ktory jest gotowy do wyswietlenia.
     *
     * @return Widok wiadomosci.
     */
    @Override
    public MessageView render() {
        return messageView.drawView();
    }
}
