package controller.implementations.message;

import controller.interfaces.MessageState;

import java.awt.*;

/**
 * Klasa reprezentujaca pusta wiadomosc.
 */
public class MessageEmpty implements MessageState {

    /**
     * Metoda rysujaca pusta wiadomosc.
     *
     * @param g          Grafika.
     * @param startPoint Punkt poczatkowy.
     */
    @Override
    public void paint(Graphics g, Point startPoint) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, 52, 32);
    }

    /**
     * Informacja o mozliwosci przetworzenia w celu wyslania wiadomosci.
     *
     * @return false, poniewaz wiadomosc jest pusta.
     */
    @Override
    public boolean canProcessing() {
        return false;
    }
}
