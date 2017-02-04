package controller.implementations;

import controller.implementations.box.BoxEmptyState;
import controller.implementations.box.BoxProcessingState;
import controller.implementations.box.BoxReadyState;
import controller.interfaces.BoxCtrlInterface;
import controller.interfaces.BoxState;
import controller.interfaces.MessageBoxesCtrlInterface;
import controller.interfaces.MessageCtrlInterface;
import models.Message;
import views.MessageBox;
import views.SimpleView;

import java.awt.*;

/**
 * Klasa reprezentując kontroller zarzadzający watkiem
 * Implementuje ona interfejsy BoxCtrlInterface i Runnable
 */
public class MessageBoxCtrl implements BoxCtrlInterface<MessageBox>, Runnable {
    private String threadName;

    private BoxState ready;
    private BoxState empty;
    private BoxState processing;

    private BoxState actualState;

    private MessageCtrlInterface messageCtrl;
    MessageBoxesCtrlInterface parentCtrl;

    private SimpleView<MessageBox> boxView;

    /**
     * Bezargumentowy konstruktor
     */
    public MessageBoxCtrl(String threadName, MessageBoxesCtrlInterface messageBoxesCtrl) {
        this.threadName = threadName;
        this.parentCtrl = messageBoxesCtrl;
        this.boxView = new MessageBox(this);
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
    public void setState(BoxState state) {
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
    public MessageBox render() {
        return this.boxView.drawView();
    }

    /**
     * @return Stan reprezentujący nieaktywny wątek
     */
    @Override
    public BoxState getEmpty() {
        return this.empty;
    }

    /**
     * @return Stan reprezentujaćy gotowość wątku do przetworzenia wiadomości
     */
    @Override
    public BoxState getReady() {
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
