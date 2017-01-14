package components;

import javax.swing.*;
import java.awt.*;

public class Circle extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(50, 10, 150, 150);
    }
}
