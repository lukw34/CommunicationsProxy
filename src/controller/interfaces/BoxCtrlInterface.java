package controller.interfaces;

import java.awt.*;

/**
 *
 * @param <T>
 */
public interface BoxCtrlInterface<T extends Component> extends ViewController<T> {
    void setState(BoxState state);

    void paint(Graphics g);

    void repaint();

    BoxState getEmpty();

    BoxState getReady();
}
