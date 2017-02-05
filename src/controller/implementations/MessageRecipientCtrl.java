package controller.implementations;

import controller.implementations.box.BoxEmptyState;
import controller.implementations.box.BoxProcessingState;
import controller.implementations.box.BoxReadyState;
import controller.interfaces.RecipientCtrlInterface;
import controller.interfaces.RecipientState;
import controller.interfaces.RecipientGroupCtrlInterface;
import controller.interfaces.MessageCtrlInterface;
import models.Message;
import views.Recipient;
import views.SimpleView;

import java.awt.*;

/**
 * Klasa reprezentując kontroller zarzadzający watkiem
 * Implementuje ona interfejsy RecipientCtrlInterface i Runnable
 */
public class MessageRecipientCtrl implements RecipientCtrlInterface<Recipient>, Runnable {
    private String threadName;

    private RecipientState ready;
    private RecipientState empty;
    private RecipientState processing;

    private RecipientState actualState;

    private MessageCtrlInterface messageCtrl;
    private RecipientGroupCtrlInterface parentCtrl;

    private SimpleView<Recipient> boxView;

    /**
     * Bezargumentowy konstruktor
     */
    public MessageRecipientCtrl(String threadName, RecipientGroupCtrlInterface messageBoxesCtrl) {
        this.threadName = threadName;
        this.parentCtrl = messageBoxesCtrl;
        this.boxView = new Recipient(this);
        this.ready = new BoxReadyState();
        this.empty = new BoxEmptyState();
        this.processing = new BoxProcessingState();
        this.actualState = this.empty;
    }

    /**
     * Metoda odpowiedzialna za zmianę stanu
     *
     * @param state nowy stan
     */
    @Override
    public void setState(RecipientState state) {
        this.actualState = state;
        this.repaint();
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
        this.boxView.repaint();
    }

    /**
     * Metoda w zależności od stanu reaguje na otrzymanie wiadomości
     *
     * @param message przesyłana wiadomość
     * @return stan odpowiadający sukcesowi bądź porażce przetworzenia wiadomości
     */
    @Override
    public boolean onReciveMessage(MessageCtrlInterface message) {
        boolean isReady = this.actualState.isReady();
        if (isReady) {
            this.messageCtrl = message;
            new Thread(this).start();
        }

        return isReady;
    }

    /**
     * Metoda udostepnijaca widok.
     *
     * @return Wyrenderowany widok
     */
    @Override
    public Recipient render() {
        return this.boxView.drawView();
    }

    /**
     * Metoda zwracajaca stan odpowiedzialny za reprezentacje pustej wiadomosci.
     *
     * @return Stan reprezentujący nieaktywny wątek
     */
    @Override
    public RecipientState getEmpty() {
        return this.empty;
    }

    /**
     * Metoda zwracajaca stan reprezentujaćy gotowość wątku do przetworzenia wiadomości.
     *
     * @return Stan reprezentujaćy gotowość wątku do przetworzenia wiadomości.
     */
    @Override
    public RecipientState getReady() {
        return this.ready;
    }

    /**
     * Implementacja interfejsu runnable
     */
    @Override
    public void run() {
        this.setState(this.processing);
        try {
            Message message = messageCtrl.getMessage();
            System.out.println(this.threadName + " otrzymal wiadomość: \"" + message.getContent() + "\"");
            Thread.sleep(3000);
            message.setRecipiant(parentCtrl.getRandomRecipient());
            this.setState(this.ready);
            messageCtrl.setMessage(message);
            messageCtrl.setState(messageCtrl.getWaiting());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
