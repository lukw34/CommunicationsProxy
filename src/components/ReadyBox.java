package components;

import config.AppConfig;

import javax.swing.*;
import java.awt.*;

public class ReadyBox extends JComponent {
    private int height;
    private int width;
    private Point startPoint;

    public ReadyBox(Point startPoint) {
        this.height  = AppConfig.messageBoxHeight;
        this.width = AppConfig.messageBoxWidth;
        this.startPoint = startPoint;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fill3DRect(this.startPoint.x, this.startPoint.y, this.width, this.height, true);

        g.setColor(Color.yellow);
        g.drawRect(this.startPoint.x, this.startPoint.y, this.width, this.height);

        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.BOLD, 14));
        g.drawString("READY!", 10, 25);
    }
}
