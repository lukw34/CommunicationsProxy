package controller.implementations;

import controller.implementations.message.MessageEmpty;
import controller.implementations.message.MessageProcessing;
import controller.implementations.message.MessageWaiting;
import controller.interfaces.MessageCtrlInterface;
import controller.interfaces.MessageState;
import models.Message;
import views.MessageView;
import views.SimpleView;

import java.awt.*;
import java.util.concurrent.Semaphore;

public class MessageCtrl implements MessageCtrlInterface<MessageView> {
    private Semaphore semaphore;

    private MessageState waiting;
    private MessageState empty;
    private MessageState processing;

    private MessageState actualState;

    private SimpleView<MessageView> messageView;
    private Message message;

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

    @Override
    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public void paint(Graphics g) {
        actualState.paint(g, new Point(0, 0));
    }

    @Override
    public void repaint() {
        messageView.repaint();
    }

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
            Thread.sleep(750);
            new Thread(() -> {
                boolean isSucces = message.getRecipient().onReciveMessage(this) ;
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
