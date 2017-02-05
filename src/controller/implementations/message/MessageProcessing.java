package controller.implementations.message;

import controller.interfaces.MessageState;

import java.awt.*;

/**
 * Klasa reprezentujaca stan wiadomosci w czasie przetwarzania, w celu wyslania.
 */
public class MessageProcessing implements MessageState {
    /**
     * Metoda rysujaca wiadomosc, ktora jest przetwarzana.
     *
     * @param g          Grafika.
     * @param startPoint Punkt poczatkowy.
     */
    @Override
    public void paint(Graphics g, Point startPoint) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fill3DRect(1, 1, 50, 30, true);

        g2.setColor(Color.RED);
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
     * @return false, poniewaz wiadomosc jest przetwarzana.
     */
    @Override
    public boolean canProcessing() {
        return false;
    }
}
