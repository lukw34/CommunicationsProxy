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

    boolean onReciveMessage(MessageCtrlInterface message);

    BoxState getEmpty();

    BoxState getReady();
}
