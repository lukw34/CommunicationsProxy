package controller.interfaces;

import java.awt.*;

public interface BoxState {
    void paint (Graphics g, Point startPoint);

    boolean isReady();
}
