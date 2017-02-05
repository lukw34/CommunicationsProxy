package controller.implementations.box;

import controller.interfaces.RecipientState;
import utils.AppConfig;

import java.awt.*;


/**
 * Klasa reprezentujaca pustego adresata.
 */
public class BoxEmptyState implements RecipientState {

    /**
     * Metoda rysujaca widok prezentujaca pustego adresata.
     *
     * @param g Grafika.
     * @param startPoint Punkt poczatkowy.
     */
    @Override
    public void paint(Graphics g, Point startPoint) {
        int width = AppConfig.MESSAGE_BOX_WIDTH + 2;
        int height = AppConfig.MESSAGE_BOX_HEIGHT;
        g.clearRect(startPoint.x, startPoint.y, width, height);
    }

    /**
     * Informacja o gotowowosci adresata.
     *
     * @return true, poniewaz adresat nie istnieje.
     */
    @Override
    public boolean isReady() {
        return true;
    }
}
