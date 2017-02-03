package controller.interfaces;

import java.awt.*;

public interface MessageState {
    void paint(Graphics g, Point startPoint);

    boolean canProcessing();
}
