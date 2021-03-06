package controller.implementations.message;

import controller.interfaces.MessageState;

import java.awt.*;

/**
 * Klasa reprezentujaca stan wiadomosci oczekujacej na wyslanie.
 */
public class MessageWaiting implements MessageState {

    /**
     * Metoda rysujaca widok oczekujacej wiadomosci.
     *
     * @param g          Grafika.
     * @param startPoint Punkt poczatkowy.
     */
    @Override
    public void paint(Graphics g, Point startPoint) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fill3DRect(1, 1, 50, 30, true);

        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(0, 0, 50, 30);
        g2.drawLine(0, 0, 20, 15);
        g2.drawLine(0, 30, 20, 15);

        g2.drawLine(50, 0, 30, 15);
        g2.drawLine(50, 30, 30, 15);
        g2.drawLine(30, 15, 25, 20);
        g2.drawLine(20, 15, 25, 20);
    }

    /**
     * Informacja o mozliwosci przetworzenia w celu wyslania wiadomosci.
     *
     * @return true, poniewaz wiadomosc moze byc przetworzona.
     */
    @Override
    public boolean canProcessing() {
        return true;
    }
}

