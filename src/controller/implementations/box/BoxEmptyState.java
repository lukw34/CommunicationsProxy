package controller.implementations.box;

import controller.interfaces.BoxState;
import utils.AppConfig;

import java.awt.*;

public class BoxEmptyState implements BoxState {

    /**
     * @param g
     * @param startPoint
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
