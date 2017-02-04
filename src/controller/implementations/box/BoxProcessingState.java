package controller.implementations.box;

import controller.interfaces.BoxState;
import utils.AppConfig;

import java.awt.*;

public class BoxProcessingState  implements BoxState{
    @Override
    public void paint(Graphics g, Point startPoint) {
        int width = AppConfig.MESSAGE_BOX_WIDTH;
        int height = AppConfig.MESSAGE_BOX_HEIGHT;
        g.setColor(Color.red);
        g.fill3DRect(startPoint.x, startPoint.y, width, height, true);

        g.setColor(Color.WHITE);
        g.fill3DRect(1, 1, 50, 30, true);

        g.setColor(Color.black);
        g.drawRect(0, 0, 50, 30);
        g.drawLine(0, 0, 20, 15);
        g.drawLine(0, 30, 20, 15);

        g.drawLine(50, 0, 30, 15);
        g.drawLine(50, 30, 30, 15);
        g.drawLine(30, 15, 25, 20);
        g.drawLine(20, 15, 25, 20);
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
