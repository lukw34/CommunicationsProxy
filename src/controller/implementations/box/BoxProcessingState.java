package controller.implementations.box;

import controller.interfaces.RecipientState;
import utils.AppConfig;

import java.awt.*;

/**
 * Klasa reprezentujaca stan w ktorym adresat wykonuje obliczenia.
 */
public class BoxProcessingState implements RecipientState {

    /**
     * Metoda rysujaca widok prezentujacy wykonywanie obliczen przez adresata.
     *
     * @param g          Grafika.
     * @param startPoint Punkt poczatkowy.
     */
    @Override
    public void paint(Graphics g, Point startPoint) {
        int width = AppConfig.MESSAGE_BOX_WIDTH;
        int height = AppConfig.MESSAGE_BOX_HEIGHT;
        int boxHeight = 30;
        int boxWidth = 50;
        int rectStartX = (AppConfig.MESSAGE_BOX_WIDTH - boxWidth) / 2;
        int rectStartY = (AppConfig.MESSAGE_BOX_HEIGHT - boxHeight) / 2;
        System.out.println(rectStartY);
        g.setColor(Color.red);
        g.fill3DRect(startPoint.x, startPoint.y, width, height, true);

        g.setColor(Color.WHITE);
        g.fill3DRect(rectStartX, rectStartY, boxWidth, boxHeight, true);

        g.setColor(Color.black);
        g.drawRect(rectStartX, rectStartY, boxWidth, boxHeight);
        g.drawLine(rectStartX, rectStartY, rectStartX + 20, rectStartY + 15);
        g.drawLine(rectStartX, rectStartY + boxHeight, rectStartX + 20, rectStartY + 15);

        g.drawLine(rectStartX + boxWidth, rectStartY,  boxHeight +  rectStartX , rectStartY + 15);
        g.drawLine(rectStartX + boxWidth, rectStartY + boxHeight, rectStartX + boxHeight, rectStartY + 15);
        g.drawLine(rectStartX + boxHeight, rectStartY + 15, rectStartX + 25, rectStartY + 20);
        g.drawLine(rectStartX + 20, rectStartY + 15, rectStartX + 25, rectStartY + 20);
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
