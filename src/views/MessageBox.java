package views;

import controller.interfaces.BoxCtrlInterface;

import javax.swing.*;
import java.awt.*;

public class MessageBox extends JPanel implements SimpleView<MessageBox> {

    BoxCtrlInterface boxCtrl;

    public MessageBox(BoxCtrlInterface boxCtrl) {
        this.boxCtrl  = boxCtrl;
    }

    @Override
    public void paintComponent(Graphics g) {
        boxCtrl.paint(g);
    }

    @Override
    public MessageBox drawView() {
        return this;
    }
}
