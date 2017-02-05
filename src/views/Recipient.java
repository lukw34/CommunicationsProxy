package views;

import controller.interfaces.RecipientCtrlInterface;

import javax.swing.*;
import java.awt.*;
/**
 * Klasa reprezentujaca widok odbiorcy.
 */
public class Recipient extends JPanel implements SimpleView<Recipient> {

    //Kontroller
    private RecipientCtrlInterface recipientCtrl;

    /**
     * Tworzy obiekt klasy Recipient(widok).
     *
     * @param recipientCtrl Kontroler widoku obiorcy.
     */
    public Recipient(RecipientCtrlInterface recipientCtrl) {
        this.recipientCtrl = recipientCtrl;
    }

    /**
     * Metoda rysujaca komponent.
     *
     * @param g Grafika
     */
    @Override
    public void paintComponent(Graphics g) {
        this.recipientCtrl.paint(g);
    }

    /**
     * Torzenie(rysowanie) widoku odbiorcy.
     *
     * @return Narysowany/gotowy widok.
     */
    @Override
    public Recipient drawView() {
        return this;
    }
}
