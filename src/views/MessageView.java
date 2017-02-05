package views;

import controller.interfaces.MessageCtrlInterface;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa reprezentujaca widok wiadomosci.
 */
public class MessageView extends JPanel implements  SimpleView<MessageView> {
    //Kontroler
    private MessageCtrlInterface messageCtrl;

    /**
     * Tworzy obiekt klasy MessageView(widok).
     *
     * @param messageCtrl Kontroler widoku wiadomosci.
     */
    public MessageView(MessageCtrlInterface messageCtrl) {
        this.messageCtrl = messageCtrl;
    }

    /**
     * Metoda rysujaca komponent.
     *
     * @param g Grafika
     */
    @Override
    public void paintComponent(Graphics g) {
        messageCtrl.paint(g);
    }

    /**
     * Torzenie(rysowanie) widoku wiadomosci.
     *
     * @return Narysowany/gotowy widok.
     */
    @Override
    public MessageView drawView() {
        return this;
    }
}