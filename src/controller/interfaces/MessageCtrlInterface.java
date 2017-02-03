package controller.interfaces;

import java.awt.*;

public interface MessageCtrlInterface<T extends Component> extends ViewController<T> {
    void setState(MessageState state);

    void paint(Graphics g);

    void repaint();

    MessageState getEmpty();

    MessageState getMessage();

    void sendIfPossible() throws InterruptedException;
}
