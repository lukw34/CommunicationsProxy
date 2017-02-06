package controller.implementations.box;

import controller.interfaces.RecipientState;
import utils.AppConfig;

import java.awt.*;

/**
 * Klasa reprezentujaca stan w ktorym adresat przetwarza wiadomosc.
 */
public class BoxCountingsState implements RecipientState {

    /**
     * Metoda rysujaca widok prezentujacy przetwarzanie wiadomosci przez adresata.
     *
     * @param g          Grafika.
     * @param startPoint Punkt poczatkowy.
     */
    @Override
    public void paint(Graphics g, Point startPoint) {
        int width = AppConfig.MESSAGE_BOX_WIDTH;
        int height = AppConfig.MESSAGE_BOX_HEIGHT;
        g.setColor(Color.blue);
        g.fill3DRect(startPoint.x, startPoint.y, width, height, true);
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.BOLD, 14));
        g.drawString("Counting ...", 10, 25);
    }

    /**
     * Informacja o gotowowosci adresata.
     *
     * @return false, poniewaz adresat jest zajety.
     */
    @Override
    public boolean isReady() {
        return false;
    }
}
