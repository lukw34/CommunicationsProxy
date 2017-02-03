package controller.implementations.box;

import controller.interfaces.BoxState;
import utils.AppConfig;

import java.awt.*;

public class BoxReadyState implements BoxState {

    @Override
    public void paint(Graphics g, Point startPoint) {
        int width = AppConfig.MESSAGE_BOX_WIDTH;
        int height = AppConfig.MESSAGE_BOX_HEIGHT;
        g.setColor(Color.GREEN);
        g.fill3DRect(startPoint.x, startPoint.y, width, height, true);

        g.setColor(Color.yellow);
        g.drawRect(startPoint.x, startPoint.y, width, height);

        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.BOLD, 14));
        g.drawString("READY!", 10, 25);
    }
}
