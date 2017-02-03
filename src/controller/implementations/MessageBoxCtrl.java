package controller.implementations;


import controller.implementations.box.BoxEmptyState;
import controller.implementations.box.BoxReadyState;
import controller.interfaces.BoxCtrlInterface;
import controller.interfaces.BoxState;
import views.MessageBox;
import views.SimpleView;

import java.awt.*;

public class MessageBoxCtrl implements BoxCtrlInterface<MessageBox> {
    BoxState ready;
    BoxState empty;

    BoxState actualState;

    SimpleView<MessageBox> boxView;

    public MessageBoxCtrl() {
        boxView = new MessageBox(this);
        ready = new BoxReadyState();
        empty = new BoxEmptyState();
        actualState = empty;
    }

    @Override
    public void setState(BoxState state) {
        actualState = state;
    }

    @Override
    public void paint(Graphics g) {
        actualState.paint(g, new Point(0, 0));
    }

    @Override
    public void repaint() {
        boxView.repaint();
    }

    @Override
    public MessageBox render() {
        return boxView.drawView();
    }

    @Override
    public BoxState getEmpty() {
        return empty;
    }

    @Override
    public BoxState getReady() {
        return ready;
    }
}
