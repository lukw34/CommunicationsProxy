package components;

import config.AppConfig;

import javax.swing.*;
import java.awt.*;

public class EmptyBox extends JComponent {
    private int height;
    private int width;
    private Point startPoint;

    public EmptyBox(Point startPoint) {
        this.height  = AppConfig.messageBoxHeight;
        this.width = AppConfig.messageBoxWidth;
        this.startPoint = startPoint;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.darkGray);
        g.fill3DRect(this.startPoint.x, this.startPoint.y, this.width, this.height, true);

        g.setColor(Color.white);
        g.drawRect(this.startPoint.x, this.startPoint.y, this.width, this.height);
        g.drawLine(this.startPoint.x, this.startPoint.y, this.startPoint.x + width, this.startPoint.y + height);
        g.drawLine(this.startPoint.x, this.startPoint.y + height,
                this.startPoint.x + width, this.startPoint.y );
    }
}
